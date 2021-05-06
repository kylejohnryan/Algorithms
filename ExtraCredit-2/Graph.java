import java.util.Stack;

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

	public int getUnvisitedNeighbor(int vertex, int[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] != 1)
				return i;
		}
		return -1;
	}

	public boolean detectcycle()
	{
		// Complete the method to detect cycles in a directed graph
		// Feel free to change the return type, parameters
		// You may want to watch the cycle detection videos in unit 10 for help
		int start = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int visited[] = new int[labels.length];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}
		stack.push(start);
		while (!stack.isEmpty()) {
			int current = stack.peek();
			visited[current] = 0;

			int neighborNode = getUnvisitedNeighbor(current, visited);
			if (neighborNode != -1) {
				if (visited[neighborNode] == -1) {
					stack.push(neighborNode);
					visited[neighborNode] = 0;
				}
				else return true;
				}
				else {
					visited[current] = 1;
					stack.pop();
				}
			}
			return false;
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
		t.addEdge(2, 1, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);
		//Test cycle detection
		System.out.println(t.detectcycle());
		// Expected output: true

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

		System.out.println(g4.detectcycle());
		// Expected Output: True

		
	}

}
