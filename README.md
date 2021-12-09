# Directed Weighted Graph
This project is a oop java project that presents a GUI of a directed weighted graph. This project implements algorithms and manipulation on a graph.
## Planning
- First we examined the interfaces and the functions inside them in order to understand what we are required to do.
- Then we tried to think what are the best data stractures to use in this program. Because we need to add and remove in O(1) we desided to use hashmaps.
- Because we need to access each edge both by it's source and it's destination we desided to make 2 hashmaps, one that it's keys are sources and one that it's keys are destinations.
- For the nodes we created a hashmap that it's keys are node.key() and it's values are NodeData. 
- We also added a hashmap for all the edges that it's keys are a String "src,dest" and it's values are EdgeData.
### Tests
- the classes EdgeData, NodeData and GeoLocation has only basic functions so we'll make basic tests that only check correctness.
- for DirectedWeightedGragh we'll make both tests that check correctness and perfomance.
- for DirectedWeightedGraghAlgorithms we'll make complicated tests that check all the edge cases. 

## Class diagram
![My_DirectedWeightedGraphAlgorithmsImpl](https://user-images.githubusercontent.com/85555432/145365136-9dc0fa1d-2f4d-48d4-8e11-2f130b43eef2.png)

## running the algorithms
### 1000 nodes
- isConnected: 31 ms
- shortestPath: 94 ms
- shortestPathDist: 47 ms
- center: timeout
- dfs: 594 ms
### 10000 nodes:
- isConnected: timeout
- shortestPath: 3359 ms
- shortestPathDist: 3469 ms
- center: timeout
- dfs: 79761
### 100000 nodes:
- isConnected: timeout
- shortestPath: out of memory
- shortestPathDist: out of memory
- center: timeout
- dfs: out of memory
## How to execute
- download the jar file Ex2.jar
- open cmd
- write "java -jar Ex2.jar <json file name>

