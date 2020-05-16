package directed_graph;

public class demo {


public static void main(String[] args) {
	DirectedGraph g = new DirectedGraph();
	g.insertVertex("Zero");
	g.insertVertex("One");
	g.insertVertex("Two");
	g.insertVertex("Three");
	g.insertVertex("Four");
	g.insertVertex("Five");
	g.insertVertex("Six");
	g.insertVertex("Seven");
	g.insertVertex("Eight");
	
	g.insertEdge("One","Two");
	g.insertEdge("Two","Zero");
	g.insertEdge("Three","Four");
	g.insertEdge("Five","Seven");
	
	g.insertEdge("Eight","Two");
	g.insertEdge("Six","Three");
	g.insertEdge("Three","Eight");
	g.insertEdge("Five","Six");
	g.insertEdge("Seven","Six");
	g.display();
	g.bfsTraversal();
	g.bfsTraversal_All();
	//g.inDegree("zero");
	//System.out.println(g.inDegree("Two"));
	//System.out.println("vertices = "+ g.vertices() + ", Edges  " + g.edges());
}
}
