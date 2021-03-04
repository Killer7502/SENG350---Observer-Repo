package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	int input;
	static Scoring score;
	static CurrentScoreDisplay currentScore;
	static FinalScorePrediction predictScore;
	static PieceTitle title;
	
	public static void main(String args[]) {
		
		Scanner scnr = new Scanner(System.in);
		
		while (true) {
			printMenu();
			try {
				int input = scnr.nextInt();
				
				switch (input) {
				case 1:
					if (score == null) {
						score = new Scoring();
						currentScore = new CurrentScoreDisplay();
						score.registerObserver(currentScore);
						predictScore = new FinalScorePrediction();
						score.registerObserver(predictScore);
						title = new PieceTitle();
						score.registerObserver(title);
						System.out.println("\nNew game started between Team1 and Team2!");
					}
					else {
						System.out.println("\nGame already in progress.");
					}
					break;
				case 2:
					score.simulateQuarter();
					break;
				case 3:
					currentScore.printCurrentScores();
					break;
				case 4:
					predictScore.scorePrediction();
					break;
				case 5:
					//TODO: Implement table to store and print news title for last game
					break;
				case 6:
					//TODO: Implement table of previous games teams and scores, then print table
					break;
				case 7:
					System.out.println("\nPROGRAM EXITING");
					System.exit(1);
					break;
				default:
					System.out.println("The value entered is not an option. Please try again.");
					break;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("WARNING: Non-Integer input entered. Please try again.");
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("\n"
			+ "1. Start new Game\n"
			+ "2. Simulate Quarter\n"
			+ "3. Print current scores\n"
			+ "4. Print prediction of end game scores\n"
			+ "5. Print news title for last game\n"
			+ "6. Print table of scores for all finished games (NOT IMPLEMENTED YET)\n");
	}
}
