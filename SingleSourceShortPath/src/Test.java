import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String arg[]) {
		int V = 18;
		int source = 0;

		List<List<Vertices>> adj = new ArrayList<List<Vertices>>();

		for (int i = 0; i < V; i++) {
			List<Vertices> item = new ArrayList<Vertices>();
			adj.add(item);
		}

		adj.get(0).add(new Vertices(1, 9));
		adj.get(0).add(new Vertices(2, 27));
		adj.get(0).add(new Vertices(3, 5));
		adj.get(0).add(new Vertices(4, 3));
		adj.get(0).add(new Vertices(5, 144));
		adj.get(0).add(new Vertices(6, 150));
		adj.get(0).add(new Vertices(7, 26));
		adj.get(0).add(new Vertices(8, 99));
		adj.get(0).add(new Vertices(9, 98));
		adj.get(5).add(new Vertices(10, 77));
		adj.get(0).add(new Vertices(11, 1));
		adj.get(0).add(new Vertices(12, 300000));
		adj.get(0).add(new Vertices(13, 90));
		adj.get(0).add(new Vertices(14, 80));
		adj.get(0).add(new Vertices(15, 17));
		adj.get(0).add(new Vertices(16, 34));
		adj.get(0).add(new Vertices(17, 37));

		adj.get(2).add(new Vertices(1, 2));
		adj.get(2).add(new Vertices(3, 4));
		adj.get(15).add(new Vertices(1, 4));
		adj.get(7).add(new Vertices(6, 111));
		adj.get(2).add(new Vertices(12, 12));
		adj.get(2).add(new Vertices(17, 1));
		adj.get(2 * 2).add(new Vertices(8, 67));
		adj.get(2 + 6).add(new Vertices(5, 17));
		adj.get(14).add(new Vertices(4, 19));

		shortestPathAlgorithm spa = new shortestPathAlgorithm(V);
		spa.dAlgorithm(adj, source);

		System.out.println("The shortest route from vertices :");
		for (int i = 0; i < spa.getDistanceFromNodeToNode().length; i++)
			System.out.println(source + " to " + i + " is " + spa.getDistanceFromNodeToNode()[i]);
	}
}
