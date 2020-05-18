package directed_graph;
import java.util.*;

 class DirectedGraph {
public final int MAX_VERTICES = 30;
int n;//number of vertices
int e ;//number of edges
boolean [][] adj;/* adjacency matrix of graph its boolean 
because we have to store only 1 and 0*/
Vertex [] vertexList;// stores all the vertices of the graph

// three states of vertex
private static final int INITIAL =0;
private static final int WAITING = 1;
private static final int VISITED = 2;

public DirectedGraph() {
	adj = new boolean [MAX_VERTICES][MAX_VERTICES];
	vertexList = new Vertex[MAX_VERTICES];
	//by default n=0 e =0
	//By default adj[u][v] = false 

}
public void dfsTraversal() {
	for (int i = 0; i < n; i++) {
		vertexList[i].state = INITIAL;// make all vertices state initial
	}
	Scanner in = new Scanner(System.in);
	System.out.println("Enter starting vertex for depth first search : ");
	String s = in.next();// enter start vertex 
	dfs(getIndex(s));// get the index of start vertex and call the dfs
}
// his methot just traverse vertices reachable from start 
private void dfs(int v) {
	Stack<Integer> st = new Stack<Integer>();
	st.push(v);// push start vertex to stack
	while(!st.isEmpty()) {
		v = st.pop();// pop vertex v
		if(vertexList[v].state == INITIAL) {
			System.out.print(vertexList[v] + " ");
			vertexList[v].state =VISITED;// if v 's state is initial visit and change it state to visited
		}
		for (int i = n-1; i >=0; i--) {
			if(isAdjacent(v,i) && vertexList[i].state == INITIAL)// push all the adjacent vertices of v if their state is initial
				st.push(i);
			
		}

	}
	System.out.println();
}
// to visit all the  vertices in the graph
public void dfsTraversal_All() {
	int v;
	for (v = 0; v < n; v++) {
		vertexList[v].state=INITIAL;
	}
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter starting vertex for dfs_all : ");
		String s = scan.next();
		dfs(getIndex(s));

		for (v = 0; v < n; v++) {
			/* we added this extra loop to traverse all the vertices this loop looks for 
			all the vertices in the list that in initial state*/
			if(vertexList[v].state == INITIAL) {
				dfs(v);
			}
		}
		
		
	
}

public int vertices() {// returns total number vertices in the graph
	return n;
}
public int edges() {// returns total number of edges in the graph
	return e;
}

public void display() {// displays the adjacency matrix
	// we print our 2d array adj row by row
	System.out.println("display method");
	for (int i = 0; i < n; i++) {
		
		for (int j = 0; j < n; j++) 
			if(adj[i][j])//if element is true print one
				System.out.print("1 ");
			else//if element is false print zero
				System.out.print("0 ");
			System.out.println();
		
	}
	
}
// visit only vertices reachable from start vertex
public void bfsTraversal() {
	for (int i = 0; i < n; i++) {
		vertexList[i].state = INITIAL;
		// when the algorithm start all vertex are in initial state
		
	}
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter starting vertex for bfs");// we enter name of the start vertex
	String s = sc.next();
	bfs(getIndex(s));// we call bfs methot with the start vertex index
}


private void bfs(int v) {
	Queue<Integer> qu = new  LinkedList<Integer>();
	qu.add(v);//we insert start vertex to the queue
	vertexList[v].state = WAITING;// change its state to waiting
	while(!qu.isEmpty()) {
		v = qu.remove();
		System.out.println(vertexList[v] + " ");
		vertexList[v].state = VISITED;//when we remove vertex from queue we change its state to visited
		for (int i = 0; i < n; i++) {
			if(isAdjacent(v,i) && vertexList[i].state == INITIAL) {
				//if i adjacent to v and it in initial state add the queue and change its state to waiting
				qu.add(i);
				vertexList[i].state = WAITING;
			}
		}
	}
	System.out.println();
}

// visites all the vertices from graph
public void bfsTraversal_All() {
	int v ; 
	for (v = 0; v <n; v++) {
		vertexList[v].state = INITIAL;}
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter starting vertex for bfs : ");
	String s = sc.next();
	bfs(getIndex(s));
	
	for ( v = 0; v < n; v++) {
		// we add this extra loop to traverse all vertices this loop check vertices one by one
		if(vertexList[v].state == INITIAL ) {
			bfs(v);
		}// after this loop all the vertices visited
	}
}

public void insertVertex(String name) {// insert new vertex in the graph
	vertexList[n++] = new Vertex(name);
	/*We create new object type of Vertex and store it in vertex list in 
	index n and increase n by one */
	
}
private int getIndex(String s) {// takes name of an vertices and returns index asociated with it 
	
	for (int i = 0; i < n; i++) {
		if(s.equals(vertexList[i].name))
		    return i;
		
	}
	throw new RuntimeException("Invalid Vertex");
}

public boolean edgeExists(String s1,String s2) {/* this method returns true if there is 
an edge from s1 to s2 */
	return isAdjacent(getIndex(s1),getIndex(s2));
}
public boolean isAdjacent(int u ,int v) {/*this method return true if 
vertex with index v is adjacent to vertex with u*/
	return adj[u][v];
}


public void insertEdge(String s1,String s2) {// insert an edge vertex s1 to vertex s2
	int u = getIndex(s1);
	int v = getIndex(s2);
	if(u==v) {// we cant add edge to same vertex
		throw new IllegalArgumentException("not valid edge");
		}
	if(adj[u][v] == true) {// if we have an edge already we cant add new one
		System.out.println("edge is already present");
	}
	else {// finally we can add edge now :D
		adj[u][v] = true;
		e++;
	}
}

public void deleteEdge(String s1,String s2) {// delete the edge {s1,s2}
	int u = getIndex(s1);
	int v = getIndex(s2);
	
	if(adj[u][v]==false) {// if we dont have any edge we cant delete it 
		System.out.println("Edge not exists in graph");
	}else {// otherwise we can delete edge and decrease value of e 
		adj[u][v] = false;
		e--;
	}
	
}
// returns number of degree going out from a vertex
// number of edges going out of the vertex
//row sum = outdegree
public int outdegree(String s ) {
	int u = getIndex(s);// we get the associated index 
	int out =0;
	for (int v = 0; v < n; v++) {// find how many entries are true in the row of index we get earlier
		if(adj[u][v])
			out++;
		}
	
	return out;//returns the outdegree 
}
//return number of edge coming to a vertex
//columnSum = indegree
public int inDegree(String s) {
	int u = getIndex(s);// we get the associated index
	int in =0;
	for (int v = 0; v < n; v++) {// find how many entries are true in the column of index we get earlier
		if(adj[u][v])
			in++;
		}

	
	return in;//returns the indegree 
	}

public void degreeOfVertex(String s) {
	System.out.println(s + " Vertex Degree is : ");
	System.out.println(inDegree(s) + outdegree(s));
	//return inDegree(s) + outdegree(s); 
}


































}