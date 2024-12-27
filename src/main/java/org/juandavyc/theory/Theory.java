package org.juandavyc.theory;

import org.juandavyc.theory.services.ListProcessor;

import java.util.ArrayList;
import java.util.List;

public class Theory {

    // comsumer<t>
    // una interfaz funcional, con parametro T
    // no devuelve nada

    private final List<Object> list = new ArrayList<>();
    private final ListProcessor listProcessor;

    public Theory(ListProcessor listProcessor){
        this.listProcessor = listProcessor;
        addDefaultItems();
    }

    private void addDefaultItems(){
        list.add("Hello");
        list.add(null);
        list.add(List.of(1, 3, 4, 5));
        list.add(Float.parseFloat("22.6f"));
    }

    private <T> void printList(T value) {
        list.forEach(System.out::println);
    }
    private void printBiConsumer(Integer e, List<Integer> v) {
        System.out.println("En el index (" + e + ") se añadio: "+v);
    }

    // añado world a la lista
    public void usingConsumer(){
        this.listProcessor.usingConsumer(
                "World",
                list::add,
                this::printList
        );
    }

    public void usingBiConsumer(){
        this.listProcessor.usingBiConsumer(
            4,
                List.of(14, 12, 54),
                this::printBiConsumer,
                list::add,
                this::printBiConsumer
        );
    }

}
