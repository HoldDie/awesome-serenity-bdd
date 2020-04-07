package com.holddie.bdd.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class MathWizSteps {

	Logger log = LoggerFactory.getLogger(this.getClass());

	Caculator caculator;

	@Step("#actor starts with {0}")
	public void startsWith(int amount) {
		log.info("MathWizSteps.startsWith,amount:{}", amount);
		caculator = new Caculator(amount);
	}

	@Step("#actor add {0}")
	public void adds(int amount) {
		log.info("MathWizSteps.adds,amount:{}", amount);
		caculator.add(amount);
	}

	@Step("#actor should have {0}")
	public void shouldHave(int amount) {
		log.info("MathWizSteps.shouldHave,amount:{}", amount);
		assertThat(caculator.getTotal()).isEqualTo(amount);
	}
}
