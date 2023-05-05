package BFS;

import java.util.Scanner;

public class RunEpuzzleBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		EpuzzleSearch epuzzleSearch=new EpuzzleSearch();
		int[][] p1= {{1,0,3},{4,2,6},{7,5,8}};
		
		epuzzleSearch.runSearch(new EpuzzleState(p1), "breadthFirst");
		scanner.nextLine();
		int[][] p2= {{4,1,3},{7,2,5},{0,8,6}};
		epuzzleSearch.runSearch(new EpuzzleState(p2), "breadthFirst");
		scanner.nextLine();
		int[][] p3= {{2,3,6},{1,5,8},{4,7,0}};
		epuzzleSearch.runSearch(new EpuzzleState(p3), "breadthFirst");

	}

}
