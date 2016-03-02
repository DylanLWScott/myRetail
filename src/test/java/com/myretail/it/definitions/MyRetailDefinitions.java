package com.myretail.it.definitions;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.myretail.it.ITConfig;
import com.myretail.it.IntegrationTestState;
import com.myretail.it.steps.MyRetailSteps;
import com.myretail.model.ProductInformationResponse;


@ContextConfiguration(classes=ITConfig.class)
public class MyRetailDefinitions {
	
	@Autowired
	private IntegrationTestState state;
	
	@Autowired
	private MyRetailSteps steps;
	
	@Given("a product id")
	public void aProductId() {
		state.setProductId(13860428L);
	}
	
	@When("I request information about that id")
	public void iRequestInformationAboutThatId() {
		state.setProductInformationResponse(steps.getInformationById(state.getProductId()));
	}
	
	@Then("I will receive a product description response")
	public void iWillReceiveAProductDescriptionResponse() {
		ProductInformationResponse productInformationResponse = state.getProductInformationResponse();
		assertNotNull(productInformationResponse);
	}
	
	@Given("a productid related to a price")
	public void aProductIdRelatedToAPrice() {
		state.setProductId(13860428L);
	}
	
	@Given("a new price")
	public void aNewPrice() {
		state.setPrice(new BigDecimal(12.00));
	}
	
	@When("I request an update to that price")
	public void iRequestAnUpdateToThatPrice() {
		steps.getPriceUpdateById(state.getProductId(), state.getPrice());
	}
	
	@Then("I will be able to retrieve a new price for that id")
	public void iWilBeAbleToRetrieveANewPriceForThatId() {
		ProductInformationResponse productInformationResponse = steps.getPriceUpdateById(15117729L, new BigDecimal(99.00));
		assertNotNull(productInformationResponse);
	}
	

}
