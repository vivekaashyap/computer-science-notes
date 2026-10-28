package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	ArrayList<Edge>[] list;
	@SuppressWarnings("unchecked")
	Graph(int v){
		list = new ArrayList[v];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Edge>();
			
		}
	}
	
	public void insert(int s, int d, int w) {
		list[s].add(new Edge(s, d, w));
		list[d].add(new Edge(d, s, w));
	}
	
	public void creategraph() {
		insert(0, 1,10);
		insert(0, 2,20);
		insert(0, 3,30);
		insert(2, 1,40);
	}
	
	public void display() {
		for (ArrayList<Edge> arrayList : list) {
			System.out.println(arrayList);
		}
	}
	
	public void bfs() {
		Queue<Edge> q = new LinkedList<>();
		boolean[] isVisited = new boolean[list.length];
		q.offer(new Edge(0, 0, 0));
		while (!q.isEmpty()) {
			Edge temp = q.poll();
			if (isVisited[temp.dest] == false) {
				isVisited[temp.dest] = true;
				System.out.println(temp.dest);
//				for (int i = 0; i < list[temp.dest].size(); i++) {
//					q.offer(list[temp.dest].get(i));
//					
//				}
				
				for (Edge e : list[temp.dest]) {
					if (isVisited[e.dest] == false) 					
					  q.offer(e);
				}
			}
		}
	}
	
	
	
	public void dfs() {
		Stack<Edge> q = new Stack<>();
		boolean[] isVisited = new boolean[list.length];
		q.push(new Edge(0, 0, 0));
		while (!q.isEmpty()) {
			Edge temp = q.pop();
			if (isVisited[temp.dest] == false) {
				isVisited[temp.dest] = true;
				System.out.println(temp.dest);
//				for (int i = 0; i < list[temp.dest].size(); i++) {
//					q.offer(list[temp.dest].get(i));
//					
//				}
				
				for (Edge e : list[temp.dest]) {
					if (isVisited[e.dest] == false) 					
					  q.push(e);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
 
		Graph g = new Graph(4);
		g.creategraph();
//		g.display();
		g.dfs();
	}

}
