class Main{
	public static void main(String[] args){
		Board board = new Board(8,8);
		for(int i=0; i<8; i++){
			board.nextSolForCol(i);
		}
		board.recordSolution();
		
		static print(int[][] b){
			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					System.out.print(b[i][j]);
				}
			System.out.println();
			}
		}
		
		board.allSolutions.get(board.numOfQueens-1).
		
	}
}