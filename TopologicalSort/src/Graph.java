import java.util.LinkedList;

public class Graph {

	//Properties
    private int nodes;
    private LinkedList<Integer>[] adjacentList;

    //Getters and Setters
    public int getNodes() {
		return nodes;
	}
	public void setNodes(int x) {
		this.nodes = x;
	}

	//Constructors
	Graph(int x) {
        this.nodes = x;
        adjacentList = new LinkedList[x];
        for (int i = 0; i < x; i++) {
            adjacentList[i] = new LinkedList<>();
        }
    }

	//Methods
    public void addEdge(int source, int destination) {
        adjacentList[source].addFirst(destination);
    }

    public void topologicalSort() {
        Stack stack = new Stack(getNodes());
        boolean[] visit = new boolean[getNodes()];
        
        for (int i = 0; i < nodes; i++) {
            if (!visit[i]) {
                tsc(i, visit, stack);
            }
        }
        System.out.println("Topological Sort: ");
        for (int i = 0; i < stack.getSize() ; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
    public void tsc(int x, boolean[] v, Stack s) {
        v[x] = true;
        int size = adjacentList[x].size();
        //For loop to traverse graph.
        for (int i = 0; i < size; i++) {
            int node = adjacentList[x].get(i);
            //If not visited call the method again.
            if (!v[node]) tsc(node, v, s);
        }
        s.push(x);
    }
}
