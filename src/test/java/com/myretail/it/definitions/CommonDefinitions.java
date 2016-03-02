package com.myretail.it.definitions;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.myretail.it.ITConfig;
import com.myretail.it.IntegrationTestState;

@ContextConfiguration(classes=ITConfig.class)
public class CommonDefinitions {

	@Autowired
	private IntegrationTestState testState;
	
	@BeforeScenario
	@AfterScenario
	public void clearTestState() {
		testState.clear();
	}
}
