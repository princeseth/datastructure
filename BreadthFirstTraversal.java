import java.util.Iterator;
import java.util.LinkedList;


public class BreadthFirstTraversal {
	int V; //No. of vertices
	LinkedList<Integer> adjListArray[]; // Adjacency Lists
	
	BreadthFirstTraversal(int v){
		V = v;
		adjListArray = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjListArray[i] = new LinkedList<Integer>();
		}
	}
	// Add edge into the graph
	void addEdge(int v,int w){
		adjListArray[v].add(w);
	}
	//traverse the graph from source s.
	void BFS(int s){
		
		//Queue for BFS
		LinkedList<Integer> queue =  new LinkedList<Integer>();
		
		boolean visited[] =  new boolean[V];

		queue.add(s); // add source vertex into queue.
		visited[s] = true; // mark the node as visited.
		
		while(queue.size()!=0){
			s = queue.poll();
			System.out.print(s+" "); // remove the vertex from the queue and print the value.
			
			Iterator<Integer> itr = adjListArray[s].listIterator();
			while(itr.hasNext()){
				int n =  itr.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
	}
	
	public static void main(String []args)
	{
		BreadthFirstTraversal bfs =  new BreadthFirstTraversal(4);
		
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);
		
		bfs.BFS(2);
	}
}
//output: 2 0 3 1
