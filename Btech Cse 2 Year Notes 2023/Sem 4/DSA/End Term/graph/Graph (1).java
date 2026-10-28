package com.prims;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {
ArrayList<Edge>[] list;
int v;

@SuppressWarnings("unchecked")
public Graph(int v) {
	super();
	this.list = new ArrayList[v];
	this.v = v;
	for (int i = 0; i < v; i++) {
		list[i] = new ArrayList<Edge>();

	}
}

public void createGRAPH() {
//	list[0].add(new Edge(0, 1, 10));
//	list[0].add(new Edge(0, 2, 15));
//	list[0].add(new Edge(0, 3, 30));
//	
//	list[1].add(new Edge(1, 0, 10));
//	list[1].add(new Edge(1, 3, 40));
//	
//	list[2].add(new Edge(2, 0, 15));
//	list[2].add(new Edge(2, 3, 50));
//	
//	list[3].add(new Edge(3, 1, 50));
//	list[3].add(new Edge(3, 2, 40));
	
	list[0].add(new Edge(0, 1, 4));
	list[0].add(new Edge(0, 2, 4));
	list[1].add(new Edge(1, 2, 2));
	
	list[2].add(new Edge(2, 3, 3));
	list[2].add(new Edge(2, 5, 4));
	list[2].add(new Edge(2, 4, 2));
	
	list[3].add(new Edge(3, 5, 3));
	list[4].add(new Edge(4, 5, 3));
	
	
}

public void print() {
	for (ArrayList<Edge> arrayList : list) {
		System.out.print(arrayList+"  ");
	}
	System.out.println();
}


private static class Pair  implements Comparable<Pair> {
	int node,cost;
	
	public Pair(int node, int cost) {
		super();
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Pair o) {

		return this.cost - o.cost;
	}

	@Override
	public String toString() {
		return "[node=" + node + ", cost=" + cost + "]";
	}
	
	
}

public  int prims(ArrayList<Edge>[] graph) {
	PriorityQueue<Pair> q = new PriorityQueue<>();
	q.add(new Pair(0, 0));
	boolean visited[] = new boolean[v];
	int mst = 0;
	while (!q.isEmpty()) {
		Pair p = q.poll();
		if (!visited[p.node]) {
			visited[p.node] = true;
			mst = p.cost+mst;
			System.out.println(p);
			for (int i = 0; i < graph[p.node].size(); i++) {
				Edge e = graph[p.node].get(i);
				if (!visited[e.dest]) {
					q.add(new Pair(e.dest, e.weight));
				}
				
			}
		}
		
	}
	return mst;
}



public  int mstCost(ArrayList<Edge>[] graph) {
	PriorityQueue<Edge> q = new PriorityQueue<>();
	q.add(new Edge(0, 0,0));
	boolean visited[] = new boolean[v];
	int mst = 0;
	while (!q.isEmpty()) {
		Edge p = q.poll();
		if (!visited[p.dest]) {
			visited[p.dest] = true;
			mst = p.weight+mst;
			System.out.println(p);
			for ( Edge e : graph[p.dest]) {		
				
				q.add(e);
							
			}
		}
		
	}
	return mst;
}

public static void main(String[] args) {
	Graph g = new Graph(6);
	g.createGRAPH();
//	g.print();
	System.out.println(g.mstCost(g.list));
}
}
