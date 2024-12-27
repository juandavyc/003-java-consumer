package org.juandavyc.exercises.services;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface ListProcessor {

    <T> void consumerLetters(
            T value,
            Consumer<T> consumer1,
            Consumer<T> consumer2
    );

    <T> void consumerSum(
            T value,
            Consumer<T> consumer1,
            Consumer<T> consumer2
    );

    <T, U> void biConsumerMap(
            T key,
            U value,
            BiConsumer<T, U> biConsumer1,
            BiConsumer<T, U> biConsumer2,
            BiConsumer<T, U> biConsumer3
    );
    <T, U> void biConsumerCombine(
            T key,
            U value,
            BiConsumer<T, U> biConsumer1
    );

}
