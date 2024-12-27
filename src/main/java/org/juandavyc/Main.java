package org.juandavyc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class Main {

    // comsumer<t>
    // una interfaz funcional, con parametro T
    // no devuelve nada

    static List<Object> list = new ArrayList();

    public static void main(String[] args) {

        list.add("hello");
        list.add(null);
        list.add(List.of(1, 3, 4, 5));
        list.add(Float.parseFloat("22.6f"));

        usingConsumer(
                "World",
                list::add,
                Main::printList);

        System.out.println("-----------");

        usingBiConsumer(
                4,
                List.of(14, 12, 54),
                Main::printAfter,
                (i, v) -> list.add(i, v),
                Main::printBefore
        );

    }

    private static void printBefore(Integer e, List<Integer> v) {
        System.out.println("En el index (" + e + ") se añadio: "+v);
        //  v.forEach(System.out::println);
    }

    private static void printAfter(Integer e, List<Integer> v) {
        System.out.println("En el index (" + e + ") se intenta añadir: "+v);
      //  v.forEach(System.out::println);
    }


    public static <T, U> void usingBiConsumer(
            T oneValue,
            U otherValue,
            BiConsumer<T, U> biconsumer1,
            BiConsumer<T, U> biconsumer2,
            BiConsumer<T, U> biconsumer3
    ) {
        biconsumer1
                .andThen(biconsumer2)
                .andThen(biconsumer3)
                .accept(oneValue, otherValue);
    }

    public static <T> void printList(T value) {
        list.forEach(System.out::println);
    }

    public static <T> void usingConsumer(
            T value,
            Consumer<T> consumer1,
            Consumer<T> consumer2
    ) {
        // solo tiene accept() y andThen
        //
        var consumeCompleted = consumer1.andThen(consumer2);
        consumeCompleted.accept(value);
    }

}