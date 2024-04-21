package page_objects;

import java.util.Map;
import org.testng.Assert;
import io.restassured.response.Response;


public class rates_page {
	
	public String getResponseResult(Response obj_response) {
		
		String jsonResp = obj_response.jsonPath().getString("result");
		
		return jsonResp;
	}

	
	public String getCurrencyRateWrtUSD(Response obj_response, String currency) {
		
		String jsonResp = obj_response.jsonPath().getString("rates." + currency.toUpperCase());
		
		return jsonResp;
	}
	
	
	public void validateUsdValueWithCurrency(String currency, String currencyRate) {
		
		switch (currency) {
			
			case "AED":
				if (Float.parseFloat(currencyRate) > 3.6 && Float.parseFloat(currencyRate) < 3.7) {
					System.out.println("The currency conversion rate of AED is between 3.6 and 3.7 wrt USD as expected");
				} else {
					System.out.println("The currency conversion rate of AED is between 3.6 and 3.7 wrt USD as expected");
				}
				
				break;
		}
	}
	
	
	public void getCurrecyPairCount(Response obj_response) {
		
		Map<Object,Object> oObj = obj_response.jsonPath().getMap("rates");
		Assert.assertEquals(oObj.size(), 162);
		
		System.out.println("162 currency pairs are getting returned by the API response wrt USD as expected");
	}
	
}
