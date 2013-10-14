package org.lp.algrithms;

import java.util.ArrayList;
import java.util.Stack;

import javax.sound.midi.Sequence;

public class OneTouchDraw implements Algorithm {
	
	private int num_edges = 5;
	private int num_points = 5;
	private int num_visited_edges = 0;
	private ArrayList<Integer> sequence = new ArrayList<Integer>();
	
	private int[][] neighbor_matrix={{0,0,1,1,0},{0,0,0,1,1},{1,0,0,0,1},{1,1,0,0,0},{0,1,1,0,0}};
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<num_points;i++){
			search(i);
		}

		
	}
	
	
	
	void set_edge_visted(int from, int to){
		neighbor_matrix[from][to] = neighbor_matrix[to][from] = 0;
		sequence.add(from);
		sequence.add(to);
		num_visited_edges++;
	}
	
	void set_edge_unvisted(int from, int to){
		neighbor_matrix[from][to] = neighbor_matrix[to][from] = 1;
		sequence.remove(2*num_visited_edges-1);
		sequence.remove(2*num_visited_edges-2);
		num_visited_edges--;
	}
	
	ArrayList<Integer> getNeighbors(int from){
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(int to=0;to<5;to++){
			if(neighbor_matrix[from][to]==1)
				r.add(to);
		}
		return r;
	}
	
	private void printSequence(){
		if(sequence.isEmpty())
			return;
		int n = 0;
		for(int p:sequence){
			System.out.print(p);
			if(n%2==0) System.out.print("->");
			if(n%2==1) System.out.print(" ");
			n++;
		}
		System.out.println();
	}
	
	
	boolean search(int from){
		ArrayList<Integer> neighbors = getNeighbors(from);
		if(neighbors.isEmpty() && (num_visited_edges==num_edges)){
			printSequence();
			return true;
		}
		
		for(int to : neighbors){
			set_edge_visted(from, to);
			search(to);
			set_edge_unvisted(from, to);
		}
		
		return false;
	}
	
	boolean unrecursive_search(int from){
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(from);
		
		return false;
	}
	
	
}
