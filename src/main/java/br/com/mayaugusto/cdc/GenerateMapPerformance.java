package br.com.mayaugusto.cdc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static br.com.mayaugusto.cdc.GenerateMap.isGetter;
import static br.com.mayaugusto.cdc.GenerateMap.ofGetToProperty;

public class GenerateMapPerformance {

    private final Map<String, Method> theProperties = new HashMap<>();
    private final Class<?> aClass;

    public GenerateMapPerformance(Class<?> aClass) {
        this.aClass = aClass;
        for (Method method : aClass.getMethods()) {
            if (isGetter(method)) {
                String property = null;
                if (method.isAnnotationPresent(PropertyName.class)) {
                    property = method.getAnnotation(PropertyName.class).value();
                } else {
                    property = ofGetToProperty(method.getName());
                }
                theProperties.put(property, method);
            }
        }
    }

    public Map<String, Object> generateMap(Object o) {
        if (!aClass.isInstance(o)) {
            throw new RuntimeException("The object is not of class " + aClass.getName());
        }

        Map<String, Object> map = new HashMap<>();
        for (String property : theProperties.keySet()) {
            try {
                Method method = theProperties.get(property);
                Object value = method.invoke(o);
                map.put(property, value);
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException("The problem the generate of map ", e);
            }
        }
        return map;
    }
}
