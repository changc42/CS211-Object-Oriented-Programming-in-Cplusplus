class Main{
	public static void main(String[] args){
		
		Board board = new Board(5,4);
		/*
		for(int i=0; i<10000000; i++){
			board.nextSol();
			
		}
		*/
		
		board.nextSol();
		board.findSolutions();
		board.printSolutions();
		
		
		
	}
}