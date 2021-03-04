package main;

public class FinalScorePrediction implements Observer {
	
	int teamScore1 = 0;
	int teamScore2 = 0;
	int currentQuarter = 0;

	@Override
	public void update (int teamScore1, int teamScore2, int currentQuarter) {
		this.teamScore1 = teamScore1;
		this.teamScore2 = teamScore2;
		this.currentQuarter = currentQuarter;
		scorePrediction();
	}
	
	public void scorePrediction() {
		if (currentQuarter == 0) {
			//DO NOTHING
			//TODO: Add in pre-game predictions
		}
		else if (currentQuarter == 4) {
			//DO NOTHING -- Game has ended
		}
		else {
			int prediction1 = teamScore1 + ((teamScore1 / currentQuarter) * (4 - currentQuarter));
			int prediction2 = teamScore2 + ((teamScore2 / currentQuarter) * (4 - currentQuarter));
			
			System.out.println("\n-------------------------");
			System.out.println("GAME PREDICTIONS");
			System.out.println("Team1 score is predicted to be " + prediction1 + " at the end of quarter 4!");
			System.out.println("Team2 score is predicted to be " + prediction2 + " at the end of quarter 4!");
			System.out.println("-------------------------\n");
		}
	}

}
