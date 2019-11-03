/*
Given a r-by-c chess board, what is the maximum number of queens we can place on
the board such that the queens cannot eat any piece in one move? What are all the different
ways this maximum number of queens can be placed on the board?

Note: a filled board where the top, bottom, or edge rows are empty are not considered as solutions, for this
is a solution to a smaller board

Write a program which states the maximum number of queens and shows all the different ways
they can be placed
*/

import java.util.*;
import java.lang.Math.*;

class Board{
	int[][] b;
	private int rows, columns;
	int numOfQueens=0;
	int max=1;
	//allSolutions contains arraylists. each array list contains solutions with n number of queens
	ArrayList<ArrayList<int[][]>> allSolutions;
	
	Board(int r, int c){
		rows = r;
		columns = c;
		b = new int[r][c];
		allSolutions = new ArrayList<>();
		
		for(int i=0; i<Math.min(r,c); i++){
			allSolutions.add(new ArrayList<int[][]>());
		}
	}
	
	int getRows(){
		return rows;
	}
	
	int getCols(){
		return columns;
	}
	
	int getNumOfQueens(){
		return numOfQueens;
	}
	
	int[][] getArray(){
		return b;
	}
	
	//everytime nextSolForCol is called, any queens placed in col will be removed
	void nextSolForCol(int col){
		if(colIsEmpty(col)){
			for(int i=0; i<rows; i++){
				if(!hasQueens(i, col)){
					b[i][col] = 1;
					numOfQueens++;
					return;
				}
			}
		}
		if(!colIsEmpty(col)){
			int key=0;
			for(int i=0; i<rows; i++){
				if(b[i][col]==1) key = i;
			}
			
			
			b[key][col] = 0;
			numOfQueens--;
			
			for(int i=key+1; i<rows; i++){
				if(!hasQueens(i, col)){
					b[i][col] = 1;
					numOfQueens++;
					return;
				}
			}
		}
	}
	
	void nextSol(){
		int lc = findLastColumn();
		for(int i=lc; i<columns; i++){
			nextSolForCol(i);
		}
		if(numOfQueens>max) max=numOfQueens;
		
		if(isSolution())
		allSolutions.get(numOfQueens-1).add(clone());
	}
	
	void findSolutions(){
		while(!colIsEmpty(0)){
			nextSol();
		}
	}

	private int findLastColumn(){
		for(int i=columns-1; i>=0; i--){
			for(int j=rows-1; j>=0; j--){
				if(b[j][i]==1) return i;
			}
		}
		return 0;
	}
	
	private int findLastRow(){
		for(int i=columns-1; i>=0; i--){
			for(int j=rows-1; j>=0; j--){
				if(b[j][i]==1) return j;
			}
		}
		return 0;
	}
	
	boolean colIsEmpty(int c){
		for(int i=0; i<rows; i++){
			if(b[i][c]==1) return false;
		}
		return true;
	}
	
	boolean rowIsEmpty(int r){
		for(int i=0; i<columns; i++){
			if(b[r][i]==1) return false;
		}
		return true;
	}
	
	boolean hasQueens(int r, int c){
		//checks if there is another queen in same row
		for(int i=c; i>=0; i--){
			if(b[r][i]==1) return true;
		}
		
		//checks for queens on diagonals
		for(int i=1; c-i>=0 && r-i>=0; i++){
			if(b[r-i][c-i]==1) return true;
		}
		
		for(int i=1; c-i>=0 && r+i<rows; i++){
			if(b[r+i][c-i]==1) return true;
		}
		
		return false;
	}
	
	void printSolutions(){
		
		ArrayList<int[][]> ans = allSolutions.get(max-1);
		Iterator<int[][]> it = ans.iterator();
			
		while(it.hasNext()){
			int[][] sol = it.next();
			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					System.out.print(sol[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("Max numOfQueens=" + (max));
		System.out.println("Number of Solutions: " + allSolutions.get(max-1).size());
	}
	
	//this prints a reflection of the board through the x-y axis. used for debugging
	void printSolutionsOpp(){
		
		ArrayList<int[][]> ans = allSolutions.get(max-1);
		Iterator<int[][]> it = ans.iterator();
			
		while(it.hasNext()){
			int[][] sol = it.next();
			for(int i=0; i<columns; i++){
				for(int j=0; j<rows; j++){
					System.out.print(sol[j][i]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("Max numOfQueens=" + (max));
		System.out.println("Number of Solutions: " + allSolutions.get(max-1).size());
	}
	
	boolean isSolution(){
		int lc = findLastColumn();
		for(int i=lc+1; i<columns; i++){
			for(int j=0; j<rows; j++){
				if(!hasQueens(j, i)){
					return false;
				}
			}
		}
		
		if(colIsEmpty(0) || colIsEmpty(columns-1) || rowIsEmpty(0) || rowIsEmpty(rows-1)) return false;
		return true;
		
	}
	
	void printBoard(){
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
	}
	
	//for debugging
	void printOpp(){
		for(int i=0; i<columns; i++){
			for(int j=0; j<rows; j++){
				System.out.print(b[j][i]);
			}
		}
	}
	
	protected int[][] clone(){
		int[][] ans = new int[rows][columns];
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				ans[i][j]=b[i][j];
			}
		}
		return ans;
	}
	
	
}