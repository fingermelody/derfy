package org.lp.algrithms;

import java.util.ArrayList;
import java.util.Random;

public class CleanDirt implements Algorithm {
	private int[][] rooms = new int[16][16];
	private int[] dirts = new int[3];
	private ArrayList<Integer> room_visited;
	private int[] path;
	static int costs;
	int steps;
	static int dirts_cleaned;
	public CleanDirt(){
		costs = 100000;
		steps = 0;
		dirts_cleaned = 0;
		room_visited = new ArrayList<Integer>();
		path = new int[100];
	}
	private void initialRoomsConnection(){
		rooms[0][1] = rooms[0][4] = 1;
		rooms[1][0] = rooms[1][2] = rooms[1][5] = 1;
		rooms[2][1] = rooms[2][3] = rooms[2][6] = 1;
		rooms[3][2] = rooms[3][7] = 1;
		rooms[4][0] = rooms[4][5] = rooms[4][8] = 1;
		rooms[5][1] = rooms[5][4] = rooms[5][6] = rooms[5][9] = 1;
		rooms[6][2] = rooms[6][5] = rooms[6][7] = rooms[6][10] = 1;
		rooms[7][3] = rooms[7][6] = rooms[7][11] = 1;
		rooms[8][4] = rooms[8][9] = rooms[8][12] = 1;
		rooms[9][5] = rooms[9][8] = rooms[9][10] = rooms[9][13] = 1;
		rooms[10][6] = rooms[10][9] = rooms[10][11] = rooms[10][14] = 1;
		rooms[11][7] = rooms[11][10] = rooms[11][15] = 1;
		rooms[12][8] = rooms[12][13] = 1;
		rooms[13][9] = rooms[13][12] = rooms[13][14] = 1;
		rooms[14][10] = rooms[14][13] = rooms[14][15] = 1;
		rooms[15][11] = rooms[15][14] = 1;
	}
	
	private void initialDirtsTest(){
		dirts[0] = 0;
		dirts[1] = 5;
		dirts[2] = 9;
	}
	private void initialDirtsRandom(){
		Random r = new Random();
//		dirts[0] = r.nextInt(16);
//		
//		do{
//			dirts[1] = r.nextInt(16);
//		}while(dirts[1]==dirts[0]);
//		
//		do{
//			dirts[1] = r.nextInt(16);
//		}while(dirts[2]==dirts[0] || dirts[2]==dirts[1]);
		
		do{
			dirts[0] = r.nextInt(16);
			dirts[1] = r.nextInt(16);
			dirts[2] = r.nextInt(16);
		}while(dirts[1]==dirts[0] || dirts[1]==dirts[2] || dirts[2]==dirts[0]);
		
		System.out.println("dirty rooms are: ");
		for(int i = 0;i < 3; i++)
			System.out.print(dirts[i]+"  ");
		System.out.println("");
	}
	
	private boolean find_dirt(int room){
		for(int i:dirts){
			if(i == room)
				return true;
		}
		return false;
	}
	
	private ArrayList<Integer> getUnvisitedNeighbors(int from){
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		for(int i=0; i<16; i++){
			if(rooms[from][i]==1 && !room_visited.contains(i))
				neighbors.add(i);
		}
		return neighbors;
	}
	
	private int copy_path(){
		
		for(int n=0; n<=costs; n++)
			path[n] = room_visited.get(n);
		
		return 0;
	}
	
	private void print_path(){
		System.out.println("there are "+costs+" steps , they are");
		for(int i=0;i<=costs;i++)
			System.out.print(path[i]+" ");
	}
	
	
	private boolean search(int from){
		room_visited.add(from);
		
		if(find_dirt(from))
			dirts_cleaned++;
			
		ArrayList<Integer> unvisited_neighbors = getUnvisitedNeighbors(from);
		if(dirts_cleaned == 3){
			if(steps<costs){
				costs = steps;
				copy_path();
			}
			return true;
		}
		
		if(unvisited_neighbors.isEmpty())
			return false;
		
		for(int neighbor : unvisited_neighbors){		
			steps++;
			search(neighbor);
			if(find_dirt(neighbor))
				dirts_cleaned--;
			steps--;
			room_visited.remove(room_visited.size()-1);
//			room_visited.remove(room_visited.indexOf(from));
		}
		
		return false;
	}
	
	@Override
	public void run() {
		
		initialRoomsConnection();
		
		initialDirtsRandom();
		//initialDirtsTest();
		search(0);
		
		print_path();
	}

}
