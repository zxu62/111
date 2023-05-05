package Astar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EpuzzleStateHam extends SearchState {

	private int[][] puzzle=new int[3][3];
	private int r0;
	private int c0;
	
	public EpuzzleStateHam(int[][] puzzle,int lc) {
		// TODO Auto-generated constructor stub
		this.puzzle=puzzle;
		this.localCost=lc;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (puzzle[i][j]==0) {
					r0=i;
					c0=j;
					
				}
			}
		}
		estRemCost=hamming();
	}
	/**
	 * compute hamming
	 * @return
	 */
	private int hamming() {
		int cost=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (puzzle[i][j]==0) {
					continue;
				}
				if (puzzle[i][j]!=i*3+j+1) {
					cost++;
				}
			}
		}
		
		return cost;
	}
	

	/**
	 * is goal?
	 * 
	 */
	@Override
	boolean goalPredicate(Search searcher) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i==2&&j==2) {
					continue;
				}
				
				if (i*3+j+1!=puzzle[i][j]) {
					return false;
				}
			}
			
		}
		
		return true;
	}

	/**
	 * Successors states
	 */
	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		// TODO Auto-generated method stub
		ArrayList<SearchState> arrayList=new ArrayList<>();
		int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
		for (int[] is : dirs) {
			int nr=r0+is[0];
			int nc=c0+is[1];
			if (nr>=0&&nr<3&&nc>=0&&nc<3) {
				int [][] copy=copyPuzzle();
				copy[r0][c0]=copy[nr][nc];
				copy[nr][nc]=0;
				arrayList.add(new EpuzzleStateHam(copy,estRemCost));
			}
		}
		return arrayList;
	}

	/**
	 * is same?
	 * 
	 */
	@Override
	boolean sameState(SearchState n2) {
		// TODO Auto-generated method stub
		if (!(n2 instanceof EpuzzleStateHam)) {
			return false;
		}
		EpuzzleStateHam epuzzleState=(EpuzzleStateHam)n2;
		for (int i = 0; i <3; i++) {
			for (int j = 0; j <3; j++) {
				if (puzzle[i][j]!=epuzzleState.puzzle[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * copy puzzle
	 * @return
	 */
	private int[][] copyPuzzle() {
		int [][] copy=new int[3][3];
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 3; j++) {
				copy[i][j]=puzzle[i][j];
			}
		}
		return copy;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("\n");
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 3; j++) {
				stringBuilder.append(puzzle[i][j]+" ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
