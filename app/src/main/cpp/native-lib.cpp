#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_tora_khabartimes_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "a9589957-22ce-4ae9-9c5b-e1c87fdc935a";
    return env->NewStringUTF(hello.c_str());
}