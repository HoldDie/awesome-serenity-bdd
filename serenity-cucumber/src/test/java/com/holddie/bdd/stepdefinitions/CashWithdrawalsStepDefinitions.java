package com.holddie.bdd.stepdefinitions;

import com.holddie.bdd.action.AccountBalanceAction;
import com.holddie.bdd.action.CreateAccountAction;
import com.holddie.bdd.action.WithdrawAction;
import com.holddie.bdd.domain.AccountType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class CashWithdrawalsStepDefinitions {

    @Shared
    CreateAccountAction createAnAccount;

    @Steps
    WithdrawAction withdraw;

    @Steps
    AccountBalanceAction accountBalance;

    int accountIdentifier;

    @Given("{word} has {string} in his {string} account")
    public void customerHasBalanceInHisAccountTypeAccount(String customer, String balance, String accountType) {
        accountIdentifier = createAnAccount.forCustomer(customer).ofType(AccountType.valueOf(accountType)).withABalanceOf(Integer.parseInt(balance));
    }

    @When("he withdraws {string} in cash")
    public void heWithdrawsWithdrawalInCash(String withdrawal) {
        withdraw.fromAccount(accountIdentifier).theSumOf(Integer.parseInt(withdrawal));
    }

    @Then("his remaining balance should be {string}")
    public void hisRemainingBalanceShouldBeExpectedBalance(String expectedBalance) {
        assertThat(accountBalance.forAccount(withdraw)).isEqualTo(Integer.parseInt(expectedBalance));
    }
}
