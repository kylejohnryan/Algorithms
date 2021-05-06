import java.util.Random;
import java.util.Stack;
import java.util.LinkedList;

public class Graph {
	
	private int[][] edges; // adjacency matrix
	private Object[] labels;

	public Graph(int n) {
		// n: size of nodes
		// weighted graph
		edges = new int[n][n];
		// edges[i][j] saves the weight of edge i->j, assume weight > 0
		// for unweighted graph 
		// set edges[i][j] to 1 if there exists an edge i->j
		// set edges[i][j] to 0 otherwise
		labels = new Object[n];
	}
	
	public void setLabel(int vertex, Object label) {
		//vertex: vertex index, label: vertex name
		labels[vertex] = label;
		
	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}


	public int size() {
		return edges.length;
	}


	public void addEdge(int source, int target, int w) {
		//w for weight
		edges[source][target] = w;
		//edges[target][source] = w;// undirected graph
	}

	public boolean isEdge(int source, int target) {
		//if edges[i][j] > 0, there exists an edge from vertex i to vertex j
		return edges[source][target] > 0;
	}

	public void removeEdge(int source, int target) {
		edges[source][target] = 0;
		//edges[target][source] = 0;// undirected graph
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

	public int[] neighbors(int vertex) {
		// find neighbors of a given vertex
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				count++;
		}
		final int[] answer = new int[count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				answer[count++] = i;
		}
		return answer;
	}

	public void print() {
		for (int j = 0; j < edges.length; j++) {
			//System.out.print(labels[j] + ": ");
			for (int i = 0; i < edges[j].length; i++) {
				if (edges[j][i] > 0)
					System.out.println(labels[j] + " -> "+ labels[i] + ":" + edges[j][i] + " ");
			}
			System.out.println();
		}
	}

	
	public int getUnvisitedNeighbor(int vertex, boolean[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1
		
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] == false)
				return i;
		}
		return -1;
	}

	
	public void dfs() {// DFS
	// Complete this method to traverse a graph using DFS
	// Start DFS from a randomly selected node in the graph
	// Note: Follow the pseudocode of DFS() in slides. 
	Random random = new Random();
	int randomNode = random.nextInt(labels.length);
	Stack<Integer> stack = new Stack<Integer>();
	boolean[] visited = new boolean[labels.length];
	visited[randomNode] = true;
	stack.push(randomNode);
	
	System.out.println("Here is the Adjacency List for DFS: ");
	while (!stack.isEmpty()) {
		int current = stack.pop();
		visited[current] = true;
		System.out.print(current + " ");

		for (int next: neighbors(current)) {
			if (!visited[next])
				stack.push(next);
		}
	}
	}	
	
	public void bfs() {// BFS
	// Complete this method to traverse a graph using BFS
	// Start BFS from a randomly selected node in the graph
	// Note: Follow the pseudocode of BFS() in slides. 
	Random random = new Random();
	int randomNode = random.nextInt(labels.length);
	LinkedList<Integer> queue = new LinkedList<Integer>();
	boolean[] visited = new boolean[labels.length];
	queue.add(randomNode);

	System.out.println("Here is the Adjacency List for BFS: ");
	while (queue.size() != 0) {
		randomNode = queue.poll();
		System.out.print(randomNode + " ");
		int[] allNeighbors = neighbors(randomNode);
		for (int i: allNeighbors) {
			if (!visited[i]) {
				visited[i] = true;
				queue.add(i);
			}
		}
	}	
	}
 
	public static void main(String args[]) {
		
		// An example to create a graph using the Graph class
		final Graph t = new Graph(6);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.addEdge(0, 1, 1);
		t.addEdge(0, 5, 1);
		t.addEdge(1, 2, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);
		t.print();

		final Graph g4 = new Graph(6);
		g4.setLabel(0, "A");
		g4.setLabel(1, "B");
		g4.setLabel(2, "C");
		g4.setLabel(3, "D");
		g4.setLabel(4, "E");
		g4.setLabel(5, "F");

		g4.addEdge(0,1,1);
		g4.addEdge(0,2,1);
		g4.addEdge(1,2,1);
		g4.addEdge(1,3,1);
		g4.addEdge(2,3,1);
		g4.addEdge(3,4,1);
		g4.addEdge(4,0,1);
		g4.addEdge(4,1,1);
		g4.addEdge(4,5,1);
		// Test DFS
		g4.dfs();
		System.out.println("");
		// Test BFS
		g4.bfs();
		System.out.println("");
		// 1. Complete the main method to create an adjacency list for the graph of problem 4 
		// in Assignment 10
		// 2. Print the adjacency list
		// 3. Call bfs(), dfs() on the graph (its adjacency list or adjacency matrix)
		// Note: You may want to read the existing adjacency matrix edges[][] in the Graph class to learn how to represent a graph. The adjacency list would be very similar. 
		
	}

}
