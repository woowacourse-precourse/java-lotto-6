package features;

import static model.FixedValues.*;
import static validator.Provider.*;

public class InputMoney {
	
	public int purchase_lotto() {
		while(true) {
			try {
				return validatedInputValue_money();
				//break;
			} catch(IllegalArgumentException e) {
				CREATOR.warning().warning(e);;
			}
		}
	}
	
	private int validatedInputValue_money() {
		return CREATOR.validator_money(provideMoney()).getPurchase_amount();
	}
	
	public int forTest(String test_input) {
		return CREATOR.validator_money(test_input).getPurchase_amount();
	}
}
