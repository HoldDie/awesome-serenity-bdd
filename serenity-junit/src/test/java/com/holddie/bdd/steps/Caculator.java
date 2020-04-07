package com.holddie.bdd.steps;

public class Caculator {
	private int total;

	public Caculator(int total) {
		this.total = total;
	}

	public void add(int amount) {
		this.total += amount;
	}

	public int getTotal() {
		return this.total;
	}
}
