package com.holddie.bdd.pages;

public enum FlyerStatus {
	Bronze(10000), Silver(50000), Gold(999999);
	private int distance;

	FlyerStatus(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}
}
