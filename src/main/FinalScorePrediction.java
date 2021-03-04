package main;

public class FinalScorePrediction implements Observer {
	
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
		scorePrediction();
	}
	
	public void scorePrediction() {
//		if (currentQuarter == 0) {
//			//DO NOTHING
//			//TODO: Add in pre-game predictions
//		}
//		if (currentQuarter == 4) {
//			//DO NOTHING -- Game has ended
//		}
		if (currentQuarter != 0 && currentQuarter != 4) {
			int prediction1 = teamScore1 + ((teamScore1 / currentQuarter) * (4 - currentQuarter));
			int prediction2 = teamScore2 + ((teamScore2 / currentQuarter) * (4 - currentQuarter));
			
			System.out.println("\n-------------------------");
			System.out.println("GAME PREDICTIONS");
			System.out.println(teamName1 + " score is predicted to be " + prediction1 + " at the end of quarter 4!");
			System.out.println(teamName2 + " score is predicted to be " + prediction2 + " at the end of quarter 4!");
			System.out.println("-------------------------\n");
		}
	}

}
