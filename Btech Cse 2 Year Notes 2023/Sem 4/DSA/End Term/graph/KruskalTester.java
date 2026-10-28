package com.Kruskal;

 


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
public class KruskalTester {

	static class EdgeComparator implements Comparator<Edge> {

		public int compare(Edge e1, Edge e2) {
			return e1.weight - e2.weight;
		}
	}
	
	ArrayList<Edge>[] list;
	int v;

	@SuppressWarnings("unchecked")
	public KruskalTester(int v) {
		super();
		this.list = new ArrayList[v];
		this.v = v;
		for (int i = 0; i < v; i++) {
			list[i] = new ArrayList<Edge>();

		}
	}

	public void insert(int s, int d, int w) {
		list[s].add(new Edge(s, d, w));
	}
	public void createGRAPH() {	
//		insert(0, 2, 1);
//		insert(0, 3, 5);
//		insert(0, 1, 4);
//		insert(2, 3, 2);
//		insert(2, 4, 8);
//		insert(3, 4, 1);
//		insert(3, 1, 2);
//		insert(1, 5, 3);
//		insert(4, 5, 3);
//		insert(1, 4, 3);
		
		insert(0, 1, 1);
		insert(0, 3, 1);
		insert(0, 2, 2);
		insert(1, 2, 3);
		insert(1, 4, 4);
		insert(2, 4, 2);
		insert(2, 3, 1);
		insert(3, 5, 5);
		insert(3, 4, 1);
		insert(4, 5, 8);
		
		
		
	}

	public void print() {
		for (ArrayList<Edge> arrayList : list) {
			System.out.println(arrayList+"  ");
		}
		System.out.println();
	}	
	
	public static int find(Set<Integer>[]  s,int v) {
		for (int i = 0; i < s.length; i++) {
			
			for (Integer in : s[i]) {
				if(in == v) { return i;}
			}
			
		}
		return -1;
	}
	
	

	public void kruskal(ArrayList<Edge>[] graph) {
		
		  ArrayList<Edge> al = new ArrayList<>();  
		  
	    for (ArrayList<Edge> edge : graph) {
			for (Edge e : edge) {
				al.add(e);
			}
		}
		
			
		 Collections.sort(al,new EdgeComparator());
		 int nOfVertex = this.v;
		 Set<Integer> uSet = new HashSet<>();
		 
		 @SuppressWarnings("unchecked")
		Set<Integer>[]  set = new HashSet[nOfVertex];
		 
		for (int i = 0; i < nOfVertex; i++) {
			uSet.add(i);
			set[i] = new HashSet<>();
			
		}
      
		
		 int count = 0;
		 int mstCost = 0;
		 System.out.println(uSet);
		for (Edge e : al) {
			
			if (uSet.contains(e.src) && uSet.contains(e.dest)) {
				uSet.remove(e.src);
				uSet.remove(e.dest);
				set[count].add(e.src);
				set[count].add(e.dest);
				count++;
				System.out.println(e);
				mstCost = mstCost + e.weight;
			} else if(uSet.contains(e.src) == true) {
				uSet.remove(e.src);
				int d = find(set, e.dest);
				if (d>=0) {
					set[d].add(e.src);
				}
				System.out.println(e);
				mstCost = mstCost + e.weight;
			}else if(uSet.contains(e.dest) == true) {
				uSet.remove(e.dest);
				
				int d = find(set, e.src);
				if (d>=0) {
					set[d].add(e.dest);
				}
				System.out.println(e);
				mstCost = mstCost + e.weight;
			} else {
				int d1 = find(set, e.src);
				int d2 = find(set, e.dest);
				if (d1 !=-1 && d2!=-1 && d1 != d2) {
					for (Integer in : set[d1]) {
						set[count].add(in);						
					}
					for (Integer in : set[d2]) {
						set[count].add(in);						
					}
					set[d1] = new HashSet<>();
					set[d2] = new HashSet<>();
					System.out.println(e);
					mstCost = mstCost + e.weight;
				}
				
				
			}

		}	
		
		System.out.println(mstCost);
	}

	
	

	public static void main(String[] args) {
		KruskalTester g = new KruskalTester(6);
		g.createGRAPH();
		g.kruskal(g.list);

	}
}



