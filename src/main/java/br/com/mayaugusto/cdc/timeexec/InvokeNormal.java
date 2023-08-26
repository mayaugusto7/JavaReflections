package br.com.mayaugusto.cdc.timeexec;

public class InvokeNormal implements MethodInvoke {

    @Override
    public void invokeMethod(int times) {
        TestClass tc = new TestClass();
        for (int i = 0; i < times; i++) {
            tc.emptyMethod();
        }
    }
}
