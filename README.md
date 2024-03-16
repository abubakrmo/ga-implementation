<h1>GENETIC ALGORITHM IMPLEMENTATION</h1>

This project implement three algorithms with the aim of evolving to a target string "Welcome to CS547!". The three algorithms that were implemented are:
<ul>
  <li>Genetic Algorithm</li>
  <li>Hill Climber</li>
  <li>Random Search</li>
</ul>
This project was purely written in Java and does not require any additional framework to be installed.

However you choose to run this project, either by cloning the project using git commands or downloading the zip file. Once you have the project opened in your local, follow the file path src/com/impplementation and run each class independently. 
1. Genetic Algorithm: Run the "GeneticAlgorithm.java" file.
2. HillClimber Algorithm: Run the "HillClimber.java" file.
3. Random Search: Run the "RandomSearch.java" file.

###

<h1>Findings</h1>
<h4>Genetic Algorithm against a random search</h4>
The genetic algorithm proved to be more effective in this project as it met the goal of evolving to the target string quickly compared to the random search which failed to evolve to the target string in 10000 iterations simply because of its reliance on luck, and generation of random populations without taking the previous result of the search into consideraton. The genetic algorithm iteratively evaluated the fitness of each individual in the population, picked the best individuals for reproduction and implemented crossover and mutation methods until it evolved to the target string “Welcome to CS547!”. The popula'on size in genetic algorithm was set to 1000 and a mutation rate of 0.01, the number of generations it took to evolve to the target string varied but the genetic algorithm achieved its goal of evolving to the target string in a minimum of 30 generations.

<h4>Hill Climber against genetic algorithm and random search</h4>
Hill climber like the genetic algorithm evolved to the target string, slower compared to genetic algorithm but converged to the target string faster than the random search. It took a minimum of 5000 iterations for the hill climber algorithm to evolve to the target string “Welcome to CS547!”. Unlike in genetic algorithm where the concepts of reproduction, crossover, mutation were employed. For the hill climber, a neighbour was generated, the fitness of this neighbour is then calculated and if the fitness is better than the current solution, it updates the current solution. This will then go on till it evolves to the target string or it exceeds the maximum number of iterations its set to.
