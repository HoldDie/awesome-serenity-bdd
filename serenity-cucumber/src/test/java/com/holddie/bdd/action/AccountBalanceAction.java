package com.holddie.bdd.action;

public class AccountBalanceAction {

	public Integer forAccount(WithdrawAction accountIdentifier) {
		return accountIdentifier.accountIdentifier;
	}
}
