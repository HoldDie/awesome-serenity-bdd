package com.holddie.bdd.features.earn_points;

import com.holddie.bdd.steps.TravellerEarningStatusPointsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.holddie.bdd.pages.FlyerStatus.Bronze;
import static com.holddie.bdd.pages.FlyerStatus.Silver;

@RunWith(SerenityRunner.class)
public class WhenEarningFrequentFlyerStatus {

	@Steps
	TravellerEarningStatusPointsSteps tracy;

	@Test
	public void members_should_start_with_Bronze_status() {
		tracy.joins_the_frequent_flyer_program();
		tracy.should_have_a_status_of(Bronze);
	}


	@Test
	@Title("Members earn Silver status after 10000 points (10000 km)")
	public void earn_silver_after_10000_kilometers() {
		tracy.joins_the_frequent_flyer_program();
		tracy.flies(10000);
		tracy.should_have_a_status_of(Silver);
	}

}
