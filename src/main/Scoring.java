package main;

import java.util.ArrayList;
import java.util.Random;

public class Scoring implements Subject {
	ArrayList<Observer> observerList;
	int teamScore1 = 0;
	int teamScore2 = 0;
	String teamName1 = "Team1";
	String teamName2 = "Team2";
	int currentQuarter = 0;
	Random rand = new Random();
	
	public Scoring() {
		observerList = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver (Observer o) {
		observerList.add(o);
	}

	@Override
	public void unRegisterObserver (Observer o) {
		observerList.remove(observerList.indexOf(o));
	}

	@Override
	public void notifyObservers () {
		for (Observer i : observerList) {
			i.update(teamScore1, teamName1, teamScore2, teamName2, currentQuarter);
		}
	}
	
	public void simulateQuarter() {
		if (currentQuarter != 4) {
			teamScore1 += rand.nextInt(50);
			teamScore2 += rand.nextInt(50);
			currentQuarter++;
			notifyObservers();
		}
		else {
			System.out.println("Game has already ended");
		}
	}
}
