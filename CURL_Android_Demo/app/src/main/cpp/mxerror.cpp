#include "include/mxerror.h"

jint throwNoClassDefError(JNIEnv *env, char *message) {
    jclass exClass;
    char *className = (char *) "java/lang/NoClassDefFoundError";

    exClass = env->FindClass(className);
    if (exClass == NULL) {
        return throwNoClassDefError(env, className);
    }

    return env->ThrowNew(exClass, message);
}

jint throwNoSuchMethodError(JNIEnv *env, char *className, char *methodName, char *signature) {
    jclass exClass;
    char *exClassName = (char *) "java/lang/NoSuchMethodError";
    char *msgBuf;
    jint retCode;
    size_t nMallocSize;

    exClass = env->FindClass(exClassName);
    if (exClass == NULL) {
        return throwNoClassDefError(env, exClassName);
    }

    nMallocSize = strlen(className)
                  + strlen(methodName)
                  + strlen(signature) + 8;

    msgBuf = (char *) malloc(nMallocSize);
    if (msgBuf == NULL) {
        return throwOutOfMemoryError(env, (char *) "throwNoSuchMethodError: allocating msgBuf");
    }
    memset(msgBuf, 0, nMallocSize);

    strcpy(msgBuf, className);
    strcat(msgBuf, ".");
    strcat(msgBuf, methodName);
    strcat(msgBuf, ".");
    strcat(msgBuf, signature);

    retCode = env->ThrowNew(exClass, msgBuf);
    free(msgBuf);
    return retCode;
}

jint throwNoSuchFieldError(JNIEnv *env, char *message) {
    jclass exClass;
    char *className = (char *) "java/lang/NoSuchFieldError";

    exClass = env->FindClass(className);
    if (exClass == NULL) {
        return throwNoClassDefError(env, className);
    }

    return env->ThrowNew(exClass, message);
}

jint throwOutOfMemoryError(JNIEnv *env, char *message) {
    jclass exClass;
    char *className = (char *) "java/lang/OutOfMemoryError";

    exClass = env->FindClass(className);
    if (exClass == NULL) {
        return throwNoClassDefError(env, className);
    }

    return env->ThrowNew(exClass, message);
}

jint throwIOError(JNIEnv *env, char *message) {
    jclass exClass;
    char *className = (char *) "java/io/IOException";

    exClass = env->FindClass(className);
    if (exClass == NULL) {
        return throwNoClassDefError(env, className);
    }
    return env->ThrowNew(exClass, message);
}