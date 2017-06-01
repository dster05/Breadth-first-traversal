/**
 * Created by ROM on 6/1/2017.
 */
import java.io.*;
import java.util.*;
public class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj []; // Adjacency Lists

    //constructor
    Graph(int v){
        V= v;
        adj = new LinkedList[v];
        for(int i = 0; i<v; ++i){
            adj[i] = new LinkedList();
        }
    }
    //This Function adds an edge into the graph
    void addEdge(int v, int w){
        adj[v].add(w);
    }

    // The function prints BFS traversal from a given source s
    void BFS(int s){

        //Mark all the vertices as not visited (by Default set as false)
        boolean visited[] = new boolean[V];

        //create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){

            //Dequeue a vertex from the queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            //Get all adjacent vertices of the dequeued vertex s
            //If a adjavent has not been visited then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    //Driver Method
    public static void main(String[] args){
        Graph g = new Graph(4); //number of vertices
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("Following is Bread First Traversal" + "(starting from vertex 2");

        g.BFS(2);

    }

}
