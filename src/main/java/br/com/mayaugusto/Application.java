package br.com.mayaugusto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        Cat cat = new Cat("Amarelo", 7);

        Field[] catFields = cat.getClass().getDeclaredFields();

        for (Field field : catFields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(cat, "Tom");
            }
        }

        Method[] methods = cat.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().equals("heyThisIsPrivate")) {
                method.setAccessible(true);
                method.invoke(cat);
            }
        }

        System.out.println(cat.getName());
    }
}
