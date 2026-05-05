package com.craftinginterpreters.AsrLang;

import java.util.List;
import java.util.Map;

public class AsrClass implements AsrCallable
{
    final String name;
    final AsrClass superclass;
    private final Map<String, AsrFunction> methods;
    AsrClass(String name,AsrClass superclass ,Map<String, AsrFunction> methods) {
        this.name = name;
        this.superclass=superclass;
        this.methods = methods;
    }
    AsrFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }
        if(superclass.name.equals(name)) {
            return superclass.findMethod(name);
        }

        return null;
    }
    @Override
    public String toString()
    {
        return name;
    }
    @Override
    public Object call(Interpreter interpreter, List<Object> arguments){
        AsrInstance instance=new AsrInstance(this);
        AsrFunction initializer = findMethod("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return  instance;
    }
    @Override
    public int arity()
    {

        AsrFunction initializer = findMethod("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }
}
