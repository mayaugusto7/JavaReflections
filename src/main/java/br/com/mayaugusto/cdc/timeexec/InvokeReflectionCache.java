package br.com.mayaugusto.cdc.timeexec;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeReflectionCache implements MethodInvoke {

    @Override
    public void invokeMethod(int times) {
        try {
            TestClass tc = new TestClass();
            Method method = tc.getClass().getMethod("emptyMethod");
            for (int i = 0; i < times; i++) {
                method.invoke(tc);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("I did not got invoke the method", e);
        }
    }
}
