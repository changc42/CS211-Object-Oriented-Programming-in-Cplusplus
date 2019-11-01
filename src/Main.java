class Main{
	public static void main(String[] args){
		
		Board board = new Board(9,9);
		board.nextSol();
		board.findSolutions();
		board.printSolutions();
		
		
	}
}