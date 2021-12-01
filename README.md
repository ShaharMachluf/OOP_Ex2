# Directed Weighted Graph
## Planning
- First we examined the interfaces and the functions inside them in order to understand what we are required to do.
- Then we tried to think what are the best data stractures to use in this program. Because we need to add and remove in O(1) we desided to use hashmaps.
- Because we need to access each edge both by it's source and it's destination we desided to make 2 hashmaps, one that it's keys are sources and one that it's keys are destinations.
- For the nodes we created a hashmap that it's keys are node.key() and it's values are NodeData. 
- We also added a hashmap for all the edges that it's keys are a String "src,dest" and it's values are EdgeData.