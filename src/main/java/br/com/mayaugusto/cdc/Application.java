package br.com.mayaugusto.cdc;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Product product = new Product("Design Patterns", "Book", 59.90, "Publication on the Casa do Codigo");

        Map<String, Object> props = GenerateMap.generateMap(product);

        for (String prop : props.keySet()) {
            System.out.println(prop+"="+props.get(prop));
        }
    }
}
