package com.implementation;
import java.util.Random;
public class GeneticAlgorithm {
    private static final String TARGET_STRING = "Welcome to CS547!";
    private static final String POSSIBLE_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !";
    //Population size as well as mutation rate can be manipulated for different results
    private static final int POPULATION_SIZE = 1000;
    private static final double MUTATION_RATE = 0.01;
    private static String generateRandomString() {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < TARGET_STRING.length(); i++) {
            int randomIndex = random.nextInt(POSSIBLE_CHARACTERS.length());
            char randomChar = POSSIBLE_CHARACTERS.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }
    private static int calculateFitness(String solution) {
        int fitness = 0;
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == TARGET_STRING.charAt(i)) {
                fitness++;
                System.out.println(fitness);
            }
        }
        return fitness;
    }

    private static String selectParent(String[] population, int[] fitnessScores) {
        Random random = new Random();
        int totalFitness = 0;
        for (int fitness : fitnessScores) {
            totalFitness += fitness;
        }
        int randomNumber = random.nextInt(totalFitness);
        int currentIndex = 0;
        for (int i = 0; i < population.length; i++) {
            randomNumber -= fitnessScores[i];
            if (randomNumber <= 0) {
                currentIndex = i;
                break;
            }
        }
        return population[currentIndex];
    }
    private static String crossover(String parent1, String parent2) {
        Random random = new Random();
        int crossoverPoint = random.nextInt(parent1.length());
        StringBuilder child = new StringBuilder();
        for (int i = 0; i < parent1.length(); i++) {
            if (i < crossoverPoint) {
                child.append(parent1.charAt(i));
            } else {
                child.append(parent2.charAt(i));
            }
        }
        return child.toString();
    }
    private static String mutate(String individual) {
        Random random = new Random();
        StringBuilder mutated = new StringBuilder(individual);
        for (int i = 0; i < individual.length(); i++) {
            if (random.nextDouble() < MUTATION_RATE) {
                int randomIndex = random.nextInt(POSSIBLE_CHARACTERS.length());
                char newChar = POSSIBLE_CHARACTERS.charAt(randomIndex);
                mutated.setCharAt(i, newChar);
            }
        }
        return mutated.toString();
    }
    public static void main(String[] args) {
        String[] population = new String[POPULATION_SIZE];
        for (int i = 0; i < POPULATION_SIZE; i++) {
            population[i] = generateRandomString();
        }
        int generation = 0;
        while (true) {
            int[] fitnessScores = new int[POPULATION_SIZE];
            int maxFitness = 0;
            String bestSolution = "";

            for (int i = 0; i < POPULATION_SIZE; i++) {
                String solution = population[i];
                int fitness = calculateFitness(solution);
                fitnessScores[i] = fitness;

                if (fitness > maxFitness) {
                    maxFitness = fitness;
                    bestSolution = solution;
                }
            }
            System.out.println("Generation " + generation + ": " + bestSolution);
            if (maxFitness == TARGET_STRING.length()) {
                System.out.println("It took " + generation + " generations for the GA to meet the goal of evolving the target string: " + bestSolution + ".");
                break;
            }
            String[] newPopulation = new String[POPULATION_SIZE];
            for (int i = 0; i < POPULATION_SIZE; i++) {
                String parent1 = selectParent(population, fitnessScores);
                String parent2 = selectParent(population, fitnessScores);
                String child = crossover(parent1, parent2);
                child = mutate(child);
                newPopulation[i] = child;
            }
            population = newPopulation;
            generation++;
        }
    }
}


