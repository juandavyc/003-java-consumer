package org.juandavyc.exercises;

import org.juandavyc.exercises.services.ListProcessor;

import java.util.*;

public class Exercises {

//    Crea una lista de cadenas (List<String>) y utiliza un Consumer para imprimir cada
//    cadena de la lista en mayúsculas.
//    HOLA MUNDO JAVA PROGRAMACIÓN - output

//    Crea una lista de números enteros (List<Integer>)
//    y utiliza un Consumer para imprimir la suma de todos los números en la lista.
//    La suma total es: 40 - output

//    Crea un Map<String, Integer> y utiliza un BiConsumer
//    para imprimir cada par clave-valor en el formato Clave: valor
//    Uno: 1
//    Dos: 2

//    Combinar dos listas y mostrar el resultado
//    "Ana", "Luis", "Carlos"
//    25, 30, 28

    final List<String> listString = new ArrayList<String>();
    final List<Integer> listNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));

    final Map<String, Integer> map = new HashMap<>();
    final List<String> names = Arrays.asList("Ana", "Luis", "Carlos");
    final List<Integer> ages = Arrays.asList(25, 30, 28);
    final ListProcessor listProcessor;


    public Exercises(ListProcessor listProcessor) {
        this.listProcessor = listProcessor;
    }


    public void biConsumerCombine() {

        for (int i = 0; i < names.size(); i++) {

            listProcessor.biConsumerCombine(
                    names.get(i),
                    ages.get(i),
                    (name, age) -> {
                        System.out.println("Person: " + name + " age: " + age);
                    }
            );
        }

    }

    public void biConsumerMap() {
        map.put("uno", 1);
        map.put("dos", 2);
        map.put("tres", 3);

        listProcessor.biConsumerMap(
                "cuatro",
                4,
                this::printMap,
                map::put,
                (k, v) -> {
                    this.printAllMap();
                }
        );

        //map.forEach((key, value)-> System.out.println(key+" -> "+value));

    }

    private void printAllMap() {
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private void printMap(String key, Integer value) {
        System.out.println("put: " + key + " -> " + value);
    }


    private <T> void printList(T value) {
        listString.forEach(letter -> System.out.print(letter.toUpperCase() + " "));
    }

    private <T> void printSum(T value) {
        final Integer[] sum = {0};
        listNumbers.forEach(val -> {
            sum[0] += val;
            System.out.print(val + " + ");
        });
        System.out.println("= " + sum[0]);
    }

    public void consumerLetters() {
        listString.add("Hola");
        listString.add("mundo");
        listString.add("java");

        listProcessor.consumerLetters(
                "programación",
                listString::add,
                this::printList
        );
    }

    public void consumerSum() {
        listProcessor.consumerSum(
                19,
                listNumbers::add,
                this::printSum
        );
    }

}
