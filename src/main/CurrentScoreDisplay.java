package main;

public class CurrentScoreDisplay implements Observer {
	int teamScore1 = 0;
	int teamScore2 = 0;
	int currentQuarter = 0;
	String teamName1 = "";
	String teamName2 = "";
	
	@Override
	public void update (int teamScore1, String teamName1, int teamScore2, String teamName2, int currentQuarter) {
		this.teamScore1 = teamScore1;
		this.teamScore2 = teamScore2;
		this.currentQuarter = currentQuarter;
		this.teamName1 = teamName1;
		this.teamName2 = teamName2;
		printCurrentScores();
	}

	public void printCurrentScores() {
		if (currentQuarter != 4) {
			System.out.println("\nCurrent scores at the end of Quarter " + currentQuarter + " are:");
			System.out.println(teamName1 + ": " + teamScore1 + "     " + teamName2 + ": " + teamScore2);
		}
	}
}
