package com.holddie.bdd.features.math_wiz;

import com.holddie.bdd.steps.MathWizSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ASimpleTest {

	@Steps
	MathWizSteps michael;

	@Test
	public void addingSums() {
		// Given
		michael.startsWith(1);

		// When
		michael.adds(2);

		// Then
		michael.shouldHave(3);
	}
}
