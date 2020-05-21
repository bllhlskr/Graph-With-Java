import java.util.*;

public class shortestPathAlgorithm {
	private int numberOfVertices;
	private int distanceFromNodeToNode[];
	private Set<Integer> based;
	private PriorityQueue<Vertices> priority;

	List<List<Vertices>> x;

	public shortestPathAlgorithm(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		setDistanceFromNodeToNode(new int[numberOfVertices]);
		based = new HashSet<Integer>();
		priority = new PriorityQueue<Vertices>(numberOfVertices, new Vertices());
	}

	public void dAlgorithm(List<List<Vertices>> x, int source) {
		this.x = x;

		for (int i = 0; i < numberOfVertices; i++)
			getDistanceFromNodeToNode()[i] = Integer.MAX_VALUE;

		priority.add(new Vertices(source, 0));

		getDistanceFromNodeToNode()[source] = 0;
		while (based.size() != numberOfVertices) {

			int k = priority.remove().node;

			based.add(k);

			adjacency(k);
		}
	}

	private void adjacency(int l) {
		int edgeDistance = -1;
		int newDistance = -1;

		for (int i = 0; i < x.get(l).size(); i++) {

			Vertices v = x.get(l).get(i);

			if (!based.contains(v.node)) {
				edgeDistance = v.cost;
				newDistance = getDistanceFromNodeToNode()[l] + edgeDistance;

				if (newDistance < getDistanceFromNodeToNode()[v.node])
					getDistanceFromNodeToNode()[v.node] = newDistance;

				priority.add(new Vertices(v.node, getDistanceFromNodeToNode()[v.node]));
			}
		}
	}

	public int[] getDistanceFromNodeToNode() {
		return distanceFromNodeToNode;
	}

	public void setDistanceFromNodeToNode(int distanceFromNodeToNode[]) {
		this.distanceFromNodeToNode = distanceFromNodeToNode;
	}

}
