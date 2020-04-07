package com.holddie.bdd.features.earn_points;

import com.holddie.bdd.pages.FlyerStatus;
import com.holddie.bdd.steps.TravellerEarningStatusPointsSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static com.holddie.bdd.pages.FlyerStatus.*;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads="4")
public class WhenEarningFrequentFlyerStatusUpgrades {

	@TestData
	public static Collection<Object[]> testData() {
		return Arrays.asList(
				new Object[][]{
						{0, Bronze},
						{9999, Bronze},
						{10000, Silver},
						{49999, Silver},
						{50000, Gold}
				}
		);
	}

	private int kilometersTravelled;
	private FlyerStatus expectedStatus;

	public WhenEarningFrequentFlyerStatusUpgrades(int kilometersTravelled, FlyerStatus expectedStatus) {
		this.kilometersTravelled = kilometersTravelled;
		this.expectedStatus = expectedStatus;
	}

	@Steps
	TravellerEarningStatusPointsSteps travellerEarningStatusPoints;

	@Test
	public void shouldEarnNextStatusWithEnoughPoints() {
		travellerEarningStatusPoints.joins_the_frequent_flyer_program();
		travellerEarningStatusPoints.flies(kilometersTravelled);
		travellerEarningStatusPoints.should_have_a_status_of(expectedStatus);
	}
}
