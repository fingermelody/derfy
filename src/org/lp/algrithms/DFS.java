package org.lp.algrithms;

import java.util.Stack;

import org.lp.tools.Node;

public class DFS implements Algorithm {

	private Node root;
	private Stack<Node> s;
	public DFS(){
		s = new Stack<Node>();
	}
	@Override
	public void run() {
		tree_create_random();
		if(root == null)
			return;
		s.push(root);
		root.setVisited(true);
		root.printSelf();
		while(!s.isEmpty()){
			Node n = s.peek();
			Node child = n.getUnvisitedChilden();
			if(child != null){
				s.push(child);
				child.printSelf();
				child.setVisited(true);
			}else{
				s.pop();
			}
		}
	}
	
	private Node tree_create_random(){
		root = null;
		root = new Node(0);
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node e = new Node(4);
		Node f = new Node(5);
		Node g = new Node(6);
		Node h = new Node(7);
		root.addChild(a); root.addChild(b); root.addChild(c);
		a.addChild(e); a.addChild(f);
		b.addChild(g);
		e.addChild(h);
		return root;
		
	}
	

}
