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

#ifdef __LP64__
#define SIZE_T_TYPE "%lu"
#else
#define SIZE_T_TYPE "%u"
#endif
#endif

#ifdef ANDROID
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "TestLibrary", __VA_ARGS__))
#else
#define LOGI(...) printf(__VA_ARGS__)
#endif

#include <stdlib.h>
#include <curl/curl.h>
#include <jni.h>
#include <string>

#endif //CURL_ANDROID_DEMO_MXCURL_H