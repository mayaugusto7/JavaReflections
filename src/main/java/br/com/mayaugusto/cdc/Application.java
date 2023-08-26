package br.com.mayaugusto.cdc;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Product product = new Product("Design Patterns", "Book", 59.90, "Publication on the Casa do Codigo");
        Map<String, Object> props = GenerateMap.generateMap(product);
        for (String prop : props.keySet()) {
            System.out.println(prop+"="+props.get(prop));
        }

        System.out.println();

        Person person = new Person("Maycon", "Ribeiro", 34, new Date());
        Map<String, Object> personProps = GenerateMap.generateMap(person);
        for (String prop : personProps.keySet()) {
            System.out.println(prop+"="+personProps.get(prop));
        }
    }
}
