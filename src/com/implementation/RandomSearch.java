package com.implementation;
import java.util.Random;
public class RandomSearch {
    private static final String TARGET_STRING = "Welcome to CS547!";
    private static final String ALL_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !";

    //number of iterations could be altered for different results
    private static final int MAX_ITERATIONS = 10000;
    private static String generateRandomString() {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < TARGET_STRING.length(); i++) {
            int randomIndex = random.nextInt(ALL_CHARACTERS.length());
            char randomChar = ALL_CHARACTERS.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }
    public static void main(String[] args) {
        String currentSolution = generateRandomString();
        int iterations = 0;

        while (!currentSolution.equals(TARGET_STRING) && iterations < MAX_ITERATIONS) {
            String randomSolution = generateRandomString();

            if (randomSolution.equals(TARGET_STRING)) {
                currentSolution = randomSolution;
            }
            iterations++;
        }
        if (currentSolution.equals(TARGET_STRING)) {
            System.out.println("Random search found the target string: " + currentSolution);
        } else {
            System.out.println("Random search did not find the target string before exceeding the maximum number (" + MAX_ITERATIONS + ") of iterations.");
        }
    }
}


