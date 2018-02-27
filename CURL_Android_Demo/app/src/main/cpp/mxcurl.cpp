//
// Created by BBBOND on 2018/2/24.
//

#include "include/mxcurl.h"

/**
 * 格式化请求结果
 * @param env
 * @param response
 * @return
 */
jobject formatResponse(JNIEnv *env, lchttp_response_t *response) {
    jobject res = NULL;
    char *responseClassName = "com/bbbond/curl_android_demo/mxcurl/Response";
    jclass responseClass = env->FindClass(responseClassName);
    jmethodID setHeader = env->GetMethodID(responseClass, "setHeader",
                                           "(Lcom/bbbond/curl_android_demo/mxcurl/Header;)V");
    jmethodID setBody = env->GetMethodID(responseClass, "setBody",
                                         "(Lcom/bbbond/curl_android_demo/mxcurl/ResponseBody;)V");
    jmethodID setCode = env->GetMethodID(responseClass, "setCode", "(I)V");
    res = env->AllocObject(responseClass);
    env->CallVoidMethod(res, setCode, response->code);

    char *headerClassName = "com/bbbond/curl_android_demo/mxcurl/Header";
    jclass headerClass = env->FindClass(headerClassName);
    jmethodID headerInit = env->GetMethodID(headerClass, "<init>", "(Ljava/lang/String;)V");
    jobject header = env->NewObject(headerClass, headerInit, env->NewStringUTF(response->header));

    char *responseBodyClassName = "com/bbbond/curl_android_demo/mxcurl/ResponseBody";
    jclass responseBodyClass = env->FindClass(responseBodyClassName);
    jmethodID setData = env->GetMethodID(responseBodyClass, "setData", "(Ljava/lang/String;)V");
    jobject responseBody = env->AllocObject(responseBodyClass);
    env->CallVoidMethod(responseBody, setData, env->NewStringUTF(response->text));

    env->CallVoidMethod(res, setHeader, header);
    env->CallVoidMethod(res, setBody, responseBody);

    return res;
}

/**
 * 整理头部
 * @param env
 * @param header
 * @param headerList
 */
struct curl_slist *formatHeader(JNIEnv *env, jobjectArray header, struct curl_slist *headerList) {
    jsize length = env->GetArrayLength(header);
    for (int i = 0; i < length; ++i) {
        jobject strObj = env->GetObjectArrayElement(header, i);
        headerList = curl_slist_append(headerList, env->GetStringUTFChars((jstring) strObj, FALSE));
    }
    return headerList;
}

/**
 * 释放资源
 * @param curl
 * @param error
 * @param response
 */
void cleanup(CURL *curl, lchttp_error_t *error, lchttp_response_t *response) {
    lchttp_response_destroy(response);
    lchttp_error_destroy(error);
    curl_easy_cleanup(curl);
}

/**
 * 设置URL
 * @param curl
 * @param url
 */
void setUrl(CURL *curl, char *url) {
    curl_easy_setopt(curl, CURLOPT_URL, url);
}

/**
 * 设置头部
 * @param curl
 * @param header
 */
void setHeader(CURL *curl, curl_slist *header) {
    curl_easy_setopt(curl, CURLOPT_HTTPHEADER, header);
}

void setParams(CURL *curl, char *params) {
    curl_easy_setopt(curl, CURLOPT_POSTFIELDS, params);
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_bbbond_curl_1android_1demo_mxcurl_internal_CurlUtils_get(
        JNIEnv *env,
        jobject instance,
        jstring url_,
        jobjectArray header_
) {
    const char *url = env->GetStringUTFChars(url_, 0);
    struct curl_slist *headerList = NULL;
    lchttp_error_t *error = lchttp_error_init();
    lchttp_response_t *response = lchttp_response_init();
    CURL *curl = curl_easy_init();

    LOGI("Curl get url: %s", url);

    setUrl(curl, (char *) url);
    headerList = formatHeader(env, header_, headerList);
    setHeader(curl, headerList);

    lchttp_perform(curl, response, error);

    jobject res = NULL;
    if (error->code == 0) {
        res = formatResponse(env, response);
    } else {
        throwIOError(env, error->code + error->message);
    }

    cleanup(curl, error, response);
    curl_slist_free_all(headerList);
    env->ReleaseStringUTFChars(url_, url);
    return res;
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_bbbond_curl_1android_1demo_mxcurl_internal_CurlUtils_post(
        JNIEnv *env,
        jclass type,
        jstring url_,
        jstring params_,
        jobjectArray header_
) {
    const char *url = env->GetStringUTFChars(url_, 0);
    const char *params = env->GetStringUTFChars(params_, 0);
    struct curl_slist *headerList = NULL;
    lchttp_error_t *error = lchttp_error_init();
    lchttp_response_t *response = lchttp_response_init();
    CURL *curl = curl_easy_init();

    LOGI("Curl post url: %s", url);

    setUrl(curl, (char *) url);
    headerList = formatHeader(env, header_, headerList);
    setHeader(curl, headerList);
    curl_easy_setopt(curl, CURLOPT_VERBOSE, 1);
    curl_easy_setopt(curl, CURLOPT_POST, 1);
    setParams(curl, (char *) env->GetStringUTFChars(params_, FALSE));

    lchttp_perform(curl, response, error);

    jobject res = NULL;
    if (error->code == 0) {
        res = formatResponse(env, response);
    } else {
        throwIOError(env, error->code + error->message);
    }

    cleanup(curl, error, response);
    curl_slist_free_all(headerList);
    env->ReleaseStringUTFChars(url_, url);
    env->ReleaseStringUTFChars(params_, params);
    return res;
}