package org.lp.tools;


public class Cost_Matrix {

	private int Max_n = 10;
	private float[][] cost_matrix;
	
	public Cost_Matrix(){
		cost_matrix = new float[Max_n][Max_n];
	}
	
	public float getCost(Node from, Node to){
		return cost_matrix[from.getId()][to.getId()];
	}
}
