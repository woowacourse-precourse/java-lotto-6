package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {
	private InputLottoException inputLottoException = new InputLottoException();
	
	public List<Integer> lottoNumberParser(String inputLottoNumbers){
		inputLottoException.validateInputLottoNumbersContainsNumbersAndComma(inputLottoNumbers);
		List<Integer> lottoNumbers = new ArrayList<>();
	    String[] numberStrings = inputLottoNumbers.split(",");
	    for (String numberString : numberStrings) {
	        lottoNumbers.add(Integer.parseInt(numberString));
	    }
	    Collections.sort(lottoNumbers);
	    
	    return lottoNumbers;
	}
    public int bonusNumberParser(String inputBonusNumber) {
    	inputLottoException.validateInputBonusNumber(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }
}
