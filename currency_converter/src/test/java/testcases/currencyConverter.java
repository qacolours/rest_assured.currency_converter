package testcases;

import static io.restassured.RestAssured.*;
import io.restassured.response.*;
import page_objects.rates_page;
import resources.BaseTest;
import resources.reusables;

import org.testng.Assert;
import org.testng.annotations.Test;

public class currencyConverter extends BaseTest {
	
	String currencyToBeCompared = "AED";
	
	reusables o_utils = new reusables();
	rates_page o_ratespage = new rates_page();
	
	@Test
	public void getCurrencyRates() throws Exception {
		
		try {
			
			//Get the Base URI into a variable
			baseURI = o_utils.getDataProperties("base_uri");
			
			//Process the get call
			Response oResp = o_utils.processGetCall("/v6/latest/USD");
			
			//Acceptance criteria 1: API call is successful and returns valid price
			//Acceptance criteria 2.1: Check Status Code
			int status_code = o_utils.getStatusCodeOfResponse(oResp);
			Assert.assertEquals(status_code, 200);
			
			
			//Acceptance criteria 2.2: Check Status returned by API response
			String response_result = o_ratespage.getResponseResult(oResp);
			Assert.assertEquals(response_result, "success");
			
			System.out.println("The API call is successful as it returns both Status Code 200 and Status Result as Success");
			
			
			//Acceptance criteria 3: Fetch the USD price against the AED and make sure the prices are in range on 3.6 – 3.7
			String fetchedRate = o_ratespage.getCurrencyRateWrtUSD(oResp, "AED");
			
			System.out.println("The fetched rate of AED wrt USD is " + fetchedRate);
			
			o_ratespage.validateUsdValueWithCurrency(currencyToBeCompared, fetchedRate);
			
			
			//Acceptance criteria 4: Verify that 162 currency pairs are retuned by the API
			o_ratespage.getCurrecyPairCount(oResp);
			
			
			//Acceptance criteria 5: Make sure API response matches the Json schema
			o_utils.validateJsonSchema(oResp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
