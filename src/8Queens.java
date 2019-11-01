/*
Given a r-by-c chess board, what is the maximum number of queens we can place on
the board such that the queens cannot eat any piece in one move? What are all the different
ways this maximum number of queens can be placed on the board?

Write a program which states the maximum number of queens and shows all the different ways
they can be placed
*/

import java.util.*;
import java.lang.Math;

class Board{
	int[][] b;
	int rows, columns, numOfQueens;
	ArrayList<ArrayList<int[][]>> allSolutions;
	
	Board(int r, int c){
		rows = r;
		columns = c;
		b = new int[r][c];
		allSolutions = new ArrayList<>();
		
		for(int i=0; i<min(r,c); i++){
			allSolutions.add(new ArrayList<int[][]>())
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
			int key;
			for(int i=0; i<rows; i++){
				if(b[i][col]==1)
					key = i;
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
	
	boolean hasQueens(int r, int c){
		//checks if there is another queen in same row
		for(int i=c; i>=0; i--){
			if(b[r][i]==1) return true;
		}
		
		//checks for queens on diagonals
		for(int i=1; c-i>=0 && r-i>=0; i++){
			if(b[r-i][c-i]==1) return true;
		}
		
		for(int i=1; c-i>=0 && r+i<=rows; i++){
			if(b[r+i][c-i]==1) return true;
		}
		
		return false;
	}
	
	void printBoard(){
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
	}
	
	void recordSolution(){
		allSolutions.get(numOfQueens-1).add(b);
	}
	
	
}