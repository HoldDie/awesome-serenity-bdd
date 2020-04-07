package com.holddie.bdd.steps;

import com.holddie.bdd.pages.FlyerStatus;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TravellerEarningStatusPointsSteps {

	Logger log = LoggerFactory.getLogger(this.getClass());

	private FrequentFlyer frequentFlyer;

	@Step("#actor joins the frequent flyer program")
	public void joins_the_frequent_flyer_program() {
		log.warn("actor joins the frequent flyer program");
		frequentFlyer = FrequentFlyer.withInitialBalanceOf(0);
	}

	@Step("#actor should have a status of {0}")
	public void should_have_a_status_of(FlyerStatus status) {
		log.warn("actor should have a status of {}", status);
		assertThat(frequentFlyer.getStatus()).isEqualTo(status);
	}

	@Step("#actor flies {0} km")
	public void flies(int kilometers) {
		log.warn("actor flies {} km", kilometers);
		frequentFlyer.recordFlightDistanceInKilometers(kilometers);
	}
}
