package org.juandavyc;


import org.juandavyc.exercises.Exercises;
import org.juandavyc.exercises.services.ListProcessorImpl;
import org.juandavyc.theory.Theory;


public class Main {


    public static void main(String[] args) {
        var theory = new Theory(new org.juandavyc.theory.services.ListProcessorImpl());

        System.out.println("** Theory ** ");
        System.out.println("- Consumer: ");
        theory.usingConsumer();
        System.out.println("- BiConsumer: ");
        theory.usingBiConsumer();
        System.out.println("** Exercises ** ");

        var exercises = new Exercises(new org.juandavyc.exercises.services.ListProcessorImpl());

        System.out.println("- Consumer letters");
        exercises.consumerLetters();
        System.out.println("\n- Consumer Numbers");
        exercises.consumerSum();
        System.out.println("- BiConsumer, letters map ");
        exercises.biConsumerMap();
        System.out.println("- BiConsumer, combine names and ages ");
        exercises.biConsumerCombine();
    }
}