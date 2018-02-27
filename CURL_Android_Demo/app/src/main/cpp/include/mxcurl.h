//
// Created by BBBOND on 2018/2/24.
//

#ifndef CURL_ANDROID_DEMO_MXCURL_H
#define CURL_ANDROID_DEMO_MXCURL_H

#ifndef BYTE
typedef const char BYTE;
typedef char *LPBYTE;
#endif

#ifndef BOOL
typedef short BOOL;
#define TRUE 1
#define FALSE 0
#endif

#ifndef CURL_HTTP_METHOD
typedef short CURL_HTTP_METHOD;
#define CURL_GET 0
#define CURL_POST 1
#define CURL_PUT 2
#define CURL_DELETLE 3
#endif

#ifdef ANDROID

#include <android/log.h>
#include <jni.h>
#include "mxerror.h"

#ifdef __LP64__
#define SIZE_T_TYPE "%lu"
#else
#define SIZE_T_TYPE "%u"
#endif
#endif

#ifdef ANDROID
#define LOGV(...) ((void)__android_log_print(ANDROID_LOG_VERBOSE, "MXCURL", __VA_ARGS__))
#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG  , "MXCURL", __VA_ARGS__))
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO   , "MXCURL", __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN   , "MXCURL", __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR  , "MXCURL", __VA_ARGS__))
#else
#define LOGI(...) printf(__VA_ARGS__)
#endif

#include <stdlib.h>
#include <curl/curl.h>
#include <jni.h>
#include <string.h>
#include "lchttp.h"
#include <curl/curl.h>

jobject formatResponse(JNIEnv *env, lchttp_response_t *response);

void cleanup(CURL *curl, lchttp_error_t *error, lchttp_response_t *response);

void setUrl(CURL *curl, char *url);

void setHeader(CURL *curl, curl_slist *header);

struct curl_slist *formatHeader(JNIEnv *env, jobjectArray header, struct curl_slist *headerList);

#endif //CURL_ANDROID_DEMO_MXCURL_H