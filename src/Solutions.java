class Solutions{
	
	int maxRows;
	int maxCols;
	ArrayList<Solutions for n rows<solutions for m columns<solutions for x numOfQueens<int[][]>>>>
	ArrayList<ArrayList<ArrayList<ArrayList<int[][]>>>> level1;
	ArrayList<ArrayList<ArrayList<int[][]>>> mCols;
	ArrayList<ArrayList<int[][]>> numOfQueens;
	
	//exception: r<c or r>c
	Solutions(int r, int c){
		maxRows = r;
		maxCols = c;
		
		ArrayList<>() level1 = new ArrayList<>();
		
		for(int i=0; i<r; i++){
			ArrayList<>() level2 = new ArrayList<>();
			level1.add(level2);
		}
		
		for(int i=0; i<r; i++){
			for(int j=i; j<c-i; j++){
				ArrayList<>() level3 = new ArrayList<>();
				level1.get(i).add(level3);
			}
		}
		
		for(int i=0; i<r; i++){
			for(int j=i; j<c-i; j++){
				for(int k=0; k<min(i+1,j+1); k++){
					ArrayList<>() level4 = new ArrayList<>();
					level1.get(i).get(j-i).add(level4);
				}
			}
		}
		
		
		
		
	}
	
	void addSolution(Board board){
		//adds int[][] to correct position in database depending on rows, cols, and numOfQueens
		allSolutions.get(board.getRows()).get(board.getCols()).get(board.getNumOfQueens()).add(board.getArray());
	}
	
	void print(int r, int c, int noq){
		Iterator<int[][]> it = new allSolutions.get(r).get(c).get(noq).iterator();
		while(it.hasNext()){
			int[][] b = it.next();
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					System.out.print(b[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
		}
	}
	
	
}