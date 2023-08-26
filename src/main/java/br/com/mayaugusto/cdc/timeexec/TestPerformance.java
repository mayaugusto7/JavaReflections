package br.com.mayaugusto.cdc.timeexec;

public class TestPerformance {
    public static void main(String[] args) {
        double normal = testExecute(new InvokeNormal());
        double reflection = testExecute(new InvokeReflection());

        System.out.println((reflection/normal) + "times that the normal");

        double reflectionCache = testExecute(new InvokeReflectionCache());
        System.out.println((reflectionCache/normal) + "times that the normal");
    }

    private static double testExecute(MethodInvoke invoke) {
        long millis = System.nanoTime();
        invoke.invokeMethod(100000);
        String className = invoke.getClass().getName();
        long diference = System.nanoTime() - millis;
        System.out.println("The class " + className + " delay " + diference + " nano seconds");
        return diference;
    }
}
