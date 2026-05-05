package com.craftinginterpreters.AsrLang;

import  java.util.List;
    interface AsrCallable{
        int arity();
        Object  call(Interpreter interpreter, List<Object> arguments);
    }

