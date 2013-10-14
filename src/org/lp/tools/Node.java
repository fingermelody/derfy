package org.lp.tools;

import java.util.ArrayList;
import java.util.Iterator;

public class Node {
	int id;
	private char name;
	private boolean visited;
	private ArrayList<Node> children;
	
	public Node(int id){
		this.setId(id);
		this.setVisited(false);
		this.setChildren(new ArrayList<Node>());
	}
	
	public Node(int id,char name){
		this.setId(id);
		this.setName(name);
		this.setVisited(false);
		this.setChildren(new ArrayList<Node>());
	}
	
	/*
	 * 
	 */
	public Node getUnvisitedChilden(){
		if(this.getChildren() == null || this.getChildren().isEmpty()){
			return null;
		}
		for(Node p:this.getChildren()){
			if(p.isVisited() == false)
				return p;
		}
		return null;
	}
	
	public void addChild(Node Child){
		this.getChildren().add(Child);
	}
	
	public void printSelf(){
		System.out.print(this.getId()+" ");
	}
	/* 
	 * getters and setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public ArrayList<Node> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	
}
