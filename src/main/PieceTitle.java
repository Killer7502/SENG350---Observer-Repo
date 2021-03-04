package main;

public class PieceTitle implements Observer {
	int teamScore1 = 0;
	int teamScore2 = 0;
	int currentQuarter = 0;
	int scoreDiff = 0;
	
	@Override
	public void update (int teamScore1, int teamScore2, int currentQuarter) {
		this.teamScore1 = teamScore1;
		this.teamScore2 = teamScore2;
		this.currentQuarter = currentQuarter;
		scoreDiff = teamScore1 - teamScore2;
		checkWinner();
	}
	
	private void checkWinner() {
		if (currentQuarter == 4) {
			if (scoreDiff > 0) { //Team1 Won
				createTitle("Team1", "Team2", false);
			}
			else if (scoreDiff < 0) { //Team2 Won
				createTitle("Team2", "Team1", false);
			}
			else { //Tie
				createTitle("Team1", "Team2", true);
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
			System.out.println("\nPiece Title: Team1 and Team2 tie in hard fought basketball match!");
		}
		System.out.println("Final Score:");
		System.out.println("Team1: " + teamScore1 + "     Team2: " + teamScore2);
	}
}
