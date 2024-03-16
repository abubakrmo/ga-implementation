package com.implementation;
import java.util.Random;
public class HillClimber {
    private static final String TARGET_STRING = "Welcome to CS547!";
    private static final String ALL_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !";
    //maximum number of iterations could be altered for different results, the higher the max_iterations, the higher the probability of 
    //evolving to the target string
    private static final int MAX_ITERATIONS = 1000;
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
    private static int calculateFitness(String individual) {
        int fitness = 0;
        for (int i = 0; i < individual.length(); i++) {
            if (individual.charAt(i) == TARGET_STRING.charAt(i)) {
                fitness++;
            }
        }
        return fitness;
    }
    private static String generateNeighbour(String currentSolution) {
        Random random = new Random();
        int randomIndex = random.nextInt(currentSolution.length());
        int randomCharIndex = random.nextInt(ALL_CHARACTERS.length());
        char randomChar = ALL_CHARACTERS.charAt(randomCharIndex);

        StringBuilder neighbour = new StringBuilder(currentSolution);
        neighbour.setCharAt(randomIndex, randomChar);
        return neighbour.toString();
    }
    public static void main(String[] args) {
        String currentSolution = generateRandomString();
        int currentFitness = calculateFitness(currentSolution);
        int iterations = 0;
        while (currentFitness < TARGET_STRING.length() && iterations < MAX_ITERATIONS) {
            String neighbour = generateNeighbour(currentSolution);
            int neighbourFitness = calculateFitness(neighbour);
            if (neighbourFitness > currentFitness) {
                currentSolution = neighbour;
                currentFitness = neighbourFitness;
            }
            iterations++;
        }
        if (currentFitness == TARGET_STRING.length()) {
            System.out.println("Goal of evolving the target string achieved: " + currentSolution);
        } else {
            System.out.println("Goal of evolving the target string not achieved in " + MAX_ITERATIONS + " iterations.");
        }
    }
}
