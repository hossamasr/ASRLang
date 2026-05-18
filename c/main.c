#include <stdlib.h>

#include "chunk.h"
#include "debug.h"
#include "common.h"
int main(int argc, char *argv[]) {
    Chunk chunk;
    initChunk(&chunk);
    writeChunk(&chunk,OP_RETURN);
    disassembleChunk(&chunk,"test chunck");
    freeChunk(&chunk);
    return 0;
}