import java.util.Comparator;

public class Vertices implements Comparator<Vertices> {

	public int node;
	public int cost;

	public Vertices() {
	}

	public Vertices(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	public int compare(Vertices n1, Vertices n2) {
		if (n1.cost < n2.cost)
			return -1;
		if (n1.cost > n2.cost)
			return 1;
		return 0;
	}

}
