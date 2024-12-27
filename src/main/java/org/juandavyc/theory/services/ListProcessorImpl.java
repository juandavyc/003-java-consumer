package org.juandavyc.theory.services;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ListProcessorImpl implements ListProcessor {


    public <T> void usingConsumer(T value, Consumer<T> consumer1, Consumer<T> consumer2) {
        consumer1.andThen(consumer2).accept(value);
    }

    public <T, U> void usingBiConsumer(
            T oneValue,
            U OtherValue,
            BiConsumer<T, U> biConsumer1,
            BiConsumer<T, U> biConsumer2,
            BiConsumer<T, U> biConsumer3
    ) {
        biConsumer1.andThen(biConsumer2).andThen(biConsumer3).accept(oneValue, OtherValue);
    }

}
