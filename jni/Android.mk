LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_LDLIBS := -lm -llog
LOCAL_MODULE    := mdiff
LOCAL_SRC_FILES := bzip2/dlltest.c \
bzip2/bzlib.c \
bzip2/crctable.c \
bzip2/compress.c \
bzip2/randtable.c \
bzip2/decompress.c \
bzip2/blocksort.c \
bzip2/huffman.c \
diff/bsdiff.cpp \  #diff功能需要依赖以上实现

include $(BUILD_SHARED_LIBRARY)


include $(CLEAR_VARS)
LOCAL_LDLIBS := -lm -llog
LOCAL_MODULE    := mpatch
LOCAL_SRC_FILES := \
bzip2/dlltest.c \
bzip2/bzlib.c \
bzip2/crctable.c \
bzip2/compress.c \
bzip2/randtable.c \
bzip2/decompress.c \
bzip2/blocksort.c \
bzip2/huffman.c \
diff/bspatch.cpp \  #patch功能需要依赖以上实现

include $(BUILD_SHARED_LIBRARY)

