import java.util.*;

public class MinSpanningTAlgorithm {

	Edge edgeCollection[]; // Edge Array Collection
	int numberOfVertices, numberOfEdges;

	MinSpanningTAlgorithm(int numberOfVertices, int numberOfEdges) { // Creates a graph with vertices and edges
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = numberOfEdges;
		edgeCollection = new Edge[numberOfEdges];

		for (int i = 0; i < numberOfEdges; ++i)
			edgeCollection[i] = new Edge();
	}

	public void Union(subCategory subCategories[], int a, int b) { // merging two roots with via their ranks
		int firstRoot = findIt(subCategories, a);
		int secondRoot = findIt(subCategories, b);

		if (subCategories[firstRoot].rank < subCategories[secondRoot].rank)
			subCategories[firstRoot].parent = secondRoot;
		else if (subCategories[firstRoot].rank > subCategories[secondRoot].rank)
			subCategories[secondRoot].parent = firstRoot;

		else {
			subCategories[secondRoot].parent = firstRoot;
			subCategories[firstRoot].rank++;
		}
	}

	public void minimumSpanningTree() {

		Edge result[] = new Edge[numberOfVertices]; // result of minimum spanning tree

		int resultIndexVariable = 0;
		int sortedEdgesVariable = 0;
		for (sortedEdgesVariable = 0; sortedEdgesVariable < numberOfVertices; ++sortedEdgesVariable)
			result[sortedEdgesVariable] = new Edge();

		Arrays.sort(edgeCollection);

		subCategory subCs[] = new subCategory[numberOfVertices];
		for (sortedEdgesVariable = 0; sortedEdgesVariable < numberOfVertices; ++sortedEdgesVariable)
			subCs[sortedEdgesVariable] = new subCategory();

		for (int v = 0; v < numberOfVertices; ++v) {
			subCs[v].parent = v;
			subCs[v].rank = 0;
		}

		sortedEdgesVariable = 0;

		while (resultIndexVariable < numberOfVertices - 1) {

			Edge nextEdge = new Edge();
			nextEdge = edgeCollection[sortedEdgesVariable++];

			int s = findIt(subCs, nextEdge.source);
			int m = findIt(subCs, nextEdge.destination);

			if (s != m) {
				result[resultIndexVariable++] = nextEdge;
				Union(subCs, s, m);
			}
		}

		System.out.println("In the set Minimum Spanning Tree,\nthe minimum edge amount between the two nodes is given below.");
		for (sortedEdgesVariable = 0; sortedEdgesVariable < resultIndexVariable; ++sortedEdgesVariable)
			System.out.println(result[sortedEdgesVariable].source + " <-to-> " + result[sortedEdgesVariable].destination + " == " + result[sortedEdgesVariable].weight);
	}

	int findIt(subCategory subCs[], int i) {

		if (subCs[i].parent != i)
			subCs[i].parent = findIt(subCs, subCs[i].parent);

		return subCs[i].parent;
	}
}