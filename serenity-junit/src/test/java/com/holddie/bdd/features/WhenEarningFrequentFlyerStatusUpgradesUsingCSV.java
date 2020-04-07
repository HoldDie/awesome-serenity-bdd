package com.holddie.bdd.features;

import com.holddie.bdd.pages.FlyerStatus;
import com.holddie.bdd.steps.TravellerEarningStatusPointsSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "$DATADIR/FlyerData.csv")
@Concurrent(threads = "5")
public class WhenEarningFrequentFlyerStatusUpgradesUsingCSV {

    private int kilometersTravelled;
    private FlyerStatus expectedStatus;

    public void setKilometersTravelled(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    public void setExpectedStatus(String expectedStatus) {
        this.expectedStatus = FlyerStatus.valueOf(expectedStatus);
    }

    @Qualifier
    public String qualifier() {
        return kilometersTravelled + "=>" + expectedStatus;
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
