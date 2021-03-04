package main;

public class PieceTitle implements Observer {
	int teamScore1 = 0;
	int teamScore2 = 0;
	int currentQuarter = 0;
	String teamName1 = "";
	String teamName2 = "";
	int scoreDiff = 0;
	
	@Override
	public void update (int teamScore1, String teamName1, int teamScore2, String teamName2, int currentQuarter) {
		this.teamScore1 = teamScore1;
		this.teamScore2 = teamScore2;
		this.currentQuarter = currentQuarter;
		this.teamName1 = teamName1;
		this.teamName2 = teamName2;
		scoreDiff = teamScore1 - teamScore2;
		checkWinner();
	}
	
	private void checkWinner() {
		if (currentQuarter == 4) {
			if (scoreDiff > 0) { //Team1 Won
				createTitle(teamName1, teamName2, false);
			}
			else if (scoreDiff < 0) { //Team2 Won
				createTitle(teamName2, teamName1, false);
			}
			else { //Tie
				createTitle(teamName1, teamName2, true);
			}
		}
	}
	
	private void createTitle(String winner, String loser, Boolean isTie) {
		System.out.println("\nNews Title for Recent Game:");
		if (!isTie) {
			if (Math.abs(scoreDiff) >= 45) {
				System.out.println(winner + " wins in a landside against " + loser + " in basketball game!");
			}
			else if (Math.abs(scoreDiff) >= 15) {
				System.out.println(winner + " wins against " + loser + " in recent game of basketball!");
			}
			else {
				System.out.println(winner + " pulls out a victory against " + loser + " in a close call of a basketball game!");
			}
		}
		else {
			System.out.println(winner + " and " + loser + " tie in hard fought basketball match!");
		}
		System.out.println("Final Score:");
		System.out.println(teamName1 + ": " + teamScore1 + "     " + teamName2 + ": " + teamScore2);
	}
}
