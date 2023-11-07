package features;

import lotto.Lotto;

import static model.FixedValues.*;
import static validator.Provider.*;

public class InputNumbers {
	
    public Lotto select_numbers() {
    	while(true) {
    		try {
    			return validatedInputValue_lotto();
	    		//break;
    		} catch(IllegalArgumentException e) {
    			CREATOR.warning().warning(e);
    		}
    	}
    }

    public int select_bonus() {
    	while(true) {
    		try {
	    		return validatedInputValue_bonus();
	    		//break;
    		} catch(IllegalArgumentException e) {
    			CREATOR.warning().warning(e);
    		}
    	}
    }
    
    private Lotto validatedInputValue_lotto() {
    	return CREATOR.convertor().insertLottoNums(provideLotto());
    }
    
    private int validatedInputValue_bonus() {
    	return CREATOR.convertor().bonusToInteger(provideLotto());
    }
}
