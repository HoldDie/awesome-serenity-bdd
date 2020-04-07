package com.holddie.bdd.steps;

import com.holddie.bdd.pages.FlyerStatus;

public class FrequentFlyer {
	private int distance;

	public FrequentFlyer(int kilometers) {
		this.distance = kilometers;
	}

	public static FrequentFlyer withInitialBalanceOf(int kilometers) {
		return new FrequentFlyer(kilometers);
	}

	public void recordFlightDistanceInKilometers(int kilometers) {
		this.distance += kilometers;
	}

	public FlyerStatus getStatus() {
		if (this.distance < FlyerStatus.Bronze.getDistance()) {
			return FlyerStatus.Bronze;
		}
		if (this.distance < FlyerStatus.Silver.getDistance()) {
			return FlyerStatus.Silver;
		}
		return FlyerStatus.Gold;
	}
}
