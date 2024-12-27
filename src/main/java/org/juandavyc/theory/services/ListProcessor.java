package org.juandavyc.theory.services;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface ListProcessor {

    <T> void usingConsumer(T value, Consumer<T> consumer1, Consumer<T> consumer2);

    <T, U> void usingBiConsumer(
            T oneValue,
            U OtherValue,
            BiConsumer<T, U> biConsumer1,
            BiConsumer<T, U> biConsumer2,
            BiConsumer<T, U> biConsumer3
    );
}