//
// Created by BBBOND on 2018/2/24.
//

#include "include/mxcurl.h"
#include "include/lchttp.h"
#include <curl/curl.h>

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_bbbond_curl_1android_1demo_utils_CurlUtils_get(JNIEnv *env, jobject instance,
                                                        jstring url_) {
    const char *url = env->GetStringUTFChars(url_, 0);

    LOGI("Curl url: %s", url);

    jbyteArray ret = env->NewByteArray(sizeof(url));
    env->SetByteArrayRegion(ret, 0, sizeof(url), (jbyte *) url);

    env->ReleaseStringUTFChars(url_, url);

    lchttp_error_t *error = lchttp_error_init();
    lchttp_response_t *response = lchttp_response_init();
    CURL * curl = curl_easy_init();
    curl_easy_setopt(curl, CURLOPT_URL, url);
    lchttp_perform(curl, response, error);

    LOGI("Curl code: %ld", response->code);
    LOGI("Curl text: %s", response->text);
    LOGI("Curl header: %s", response->header);

    LOGI("Curl err: %s", error->message);
    LOGI("Curl err code: %d", error->code);

    lchttp_response_destroy(response);
    lchttp_error_destroy(error);
    curl_easy_cleanup(curl);

    return ret;
}


extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_bbbond_curl_1android_1demo_utils_CurlUtils_post(JNIEnv *env, jclass type, jstring url_) {
    const char *url = env->GetStringUTFChars(url_, 0);

    env->ReleaseStringUTFChars(url_, url);
}