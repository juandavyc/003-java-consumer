package org.juandavyc.exercises.services;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ListProcessorImpl implements ListProcessor {


    public <T> void consumerLetters(
            T value,
            Consumer<T> consumer1,
            Consumer<T> consumer2
    ) {
        consumer1.andThen(consumer2).accept(value);
    }


    public <T> void consumerSum(
            T value,
            Consumer<T> consumer1,
            Consumer<T> consumer2
    ) {
        consumer1.andThen(consumer2).accept(value);
    }

    public <T, U> void biConsumerMap(
            T key,
            U value,
            BiConsumer<T, U> biConsumer1,
            BiConsumer<T, U> biConsumer2,
            BiConsumer<T, U> biConsumer3
    ) {

        biConsumer1.andThen(biConsumer2).andThen(biConsumer3).accept(key,value);
    }


    public <T, U> void biConsumerCombine(
            T key,
            U value,
            BiConsumer<T, U> biConsumer1
    ) {
        biConsumer1.accept(key,value);

    }


}
