<h1> Graphs With Java</h1>
A: A method to find the degree of a vertex: 
In the outdegree method, we get the associated index and find how many entries are true in the row of index we got earlier, and return the outdegree. In the inDegree method, we get the associated index just like in outdegree method, and then find how many entries are true in the column of index we got earlier, and return the indegree. The “vertexofdegree” method adds indegree and outdegree and gives the result. In output, vertexofdegree is called. 
<img src ='img/1'></img>
 
B: A Method for Breadth First Search:
When the user enters the name of the start vertex, firstly the start vertex is visited, then all the vertices adjacent to the start vertex are visited. Then the adjacent vertices are visited one by one and their adjacent vertices are visited.  In “bfs” method, “qu.add(v)” line inserts start vertex to the queue, then change its state to waiting. When the vertex is removed from the queue, its state is changed to “visited”. If i is adjacent to v and it is in initial state, its added to the queue and its state is changed to “waiting”.	
 
For Breadth First Search All, we have an algorithm called “bfsTraversal_All”. Its difference from “bfsTraversal” is that we have added an extra loop to traverse all vertices. This loop checks vertices one by one. After the loop, all vertices are visited. It traverses the whole graph starting from the vertex.
 
C: A Method for Depth First Search:
We have a method called dfsTraversal. The line “vertexList[i].state = INITIAL;” makes all the vertices state the initial. The user should enter start vertex, after that the line “dfs(getIndex(s));” gets the index of start vertex and calls the “dfs” method. The dfs method just traverses the vertices reachable from start. The line “st.push(v);” pushes the start vertex to the stack, and the line “v = st.pop();” pops the vertex v. Then if the state of v is initial, it gets visited and its state is changed to “visited”. Finally, if the states of all adjacent vertices of v are initial, they get pushed. 
The “dfsTraversal_All” method includes an extra loop to traverse all vertices. This loop looks for all the vertices  that are in initial state. After the loop, all vertices are visited. It traverses the whole graph starting from the vertex.
 















D: A Method for finding a Minimum Spanning Tree
Based on a bonded and weighted graph, a spanning tree is a subgraph of the primary graph. Also, that is a tree which connects all the vertices (nodes) together. Although a single graph can have lots of dissimilar spanning trees, a minimum spanning tree (MST) for a weighted, bonded and undirected graph s a spanning tree with weight less than or equal to the weight of every other spanning trees.
 
Simply, the code works like this;
1) Sort all the edges in non-decreasing order of their weight.
2) Pick the smallest edge. Check if it fits a cycle with the spanning-tree formed so far. If the cycle is not created, include this edge; otherwise, discard it
3) Repeat part 2 until there are (V-1) edges in the spanning tree.
E: A method to find Single Source Shortest Path
1) Create a shortest path tree set which tracks the vertices included in shortest path tree. Initially, this set is empty.
2) Assign a distance value to all vertices in the input graph. Initialize all distance values as infinite. Assign distance value as 0 for the source vertex so that it is picked first.
3) While the shortest path tree set that doesn’t include all vertices
….a) Pick a vertex u which is not there in shortest path tree set and has minimum distance value.
….b) Include u to shortest path tree set.
….c) Update distance value of all adjacent vertices of u. To update the distance values, iterate through all adjacent vertices. For every adjacent vertex v, if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
 

F: Topological Sort
We have a “Graph” class we have made with linked list. In construction, it creates a new linked list for every node. In topologicalSort method, we create a stack that is as long as the graph, and a Boolean list. This Boolean list is marked true if the node was visited previously, and false if it was not. Then the for loop repeats the list and calls the recursive “tsc” method everytime false is received. When this is repeated for all members, the loop ends since the stack now is in the correct order. Then the stack members are popped in order and topological sort is printed.


 
