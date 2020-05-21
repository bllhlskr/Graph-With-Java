
public class Edge implements Comparable<Edge> {
	 int destination,source, weight;

	public int compareTo(Edge compareEdge) {
		return this.weight - compareEdge.weight;
	}
};