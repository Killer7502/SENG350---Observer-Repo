package main;

public class CurrentScoreDisplay implements Observer {
	int teamScore1 = 0;
	int teamScore2 = 0;
	int currentQuarter = 0;
	
	@Override
	public void update (int teamScore1, int teamScore2, int currentQuarter) {
		this.teamScore1 = teamScore1;
		this.teamScore2 = teamScore2;
		this.currentQuarter = currentQuarter;
		printCurrentScores();
	}

	public void printCurrentScores() {
		if (currentQuarter != 4) {
			System.out.println("\nCurrent scores at the end of Quarter " + currentQuarter + " are:");
			System.out.println("Team 1: " + teamScore1 + "     Team 2: " + teamScore2);
		}
	}
}
