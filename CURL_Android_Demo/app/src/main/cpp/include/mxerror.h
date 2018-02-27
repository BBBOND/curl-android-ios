//
// Created by BBBOND on 2018/2/27.
//

#ifndef CURL_ANDROID_DEMO_MXERROR_H
#define CURL_ANDROID_DEMO_MXERROR_H

#include <android/log.h>
#include <jni.h>
#include <string.h>
#include <malloc.h>

#define LPTSTR TCHAR*;

#endif //CURL_ANDROID_DEMO_MXERROR_H

jint throwNoClassDefError(JNIEnv *env, char *message);

jint throwNoSuchMethodError(JNIEnv *env, char *className, char *methodName, char *signature);

jint throwNoSuchFieldError(JNIEnv *env, char *message);

jint throwOutOfMemoryError(JNIEnv *env, char *message);

jint throwIOError(JNIEnv *env, char *message);