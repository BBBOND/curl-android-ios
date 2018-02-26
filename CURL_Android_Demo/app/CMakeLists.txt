cmake_minimum_required(VERSION 3.4.1)

# =============== 添加静态/共享库 ===============
add_library( curl-prebuilt

             STATIC

             IMPORTED )
set_target_properties( # Specifies the target library.
                       curl-prebuilt

                       # Specifies the parameter you want to define.
                       PROPERTIES IMPORTED_LOCATION

                       # Provides the path to the library you want to import.
                       ${CMAKE_SOURCE_DIR}/../../prebuilt-with-ssl/android/${ANDROID_ABI}/libcurl.a )

add_library( # Specifies the target library.
             mxcurl

             # Specifies the parameter you want to define.
             SHARED

             # Provides the path to the library you want to import.
             src/main/cpp/mxcurl.cpp
             src/main/cpp/lchttp.cpp )

# =============== 添加头文件 ===============
target_include_directories(mxcurl PRIVATE

                           ${CMAKE_SOURCE_DIR}/../../prebuilt-with-ssl/android/include
                           src/main/cpp/include/)

# =============== 添加native api ===============
find_library(log-lib

             log )
find_library(z-lib

             z)

# =============== 把所有库文件都引入工程 ===============
target_link_libraries( # Specifies the target library.
                       mxcurl
                       curl-prebuilt

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib}
                       ${z-lib} )