//
// Created by hossam on 5/18/26.
//

#ifndef casrlang_debug_h
#define casrlang_debug_h
#include "chunk.h"
void disassembleChunk(Chunk* chunk,const char* name);
int disassembleInstruction(Chunk* chunk,int offset);
#endif
