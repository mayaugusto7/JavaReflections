package br.com.mayaugusto.cdc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GenerateMap {
    private GenerateMap() {}

    public static Map<String, Object> generateMap(Object o) throws InvocationTargetException, IllegalAccessException {
        Class<?> classe = o.getClass();
        Map<String, Object> map = new HashMap<>();
        for (Method method : classe.getDeclaredMethods()) {
                if (isGetter(method)) {
                    String property = ofGetToProperty(method.getName());
                    Object value = method.invoke(o);
                    map.put(property, value);
                }
        }
        return map;
    }

    private static String ofGetToProperty(String name) {
        return name.substring(3, 4).toLowerCase() +
                name.substring(4);
    }

    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") &&
                method.getReturnType() != void.class &&
                method.getParameterTypes().length == 0;
    }
}
