package lotto.util;

import java.util.List;
import static lotto.util.buyingLottoException.*;
import static lotto.util.PrintConstants.*;


public class InputLottoException {
    private final static int MAX_RANGE_OF_LOTTO_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static String INPUT_LOTTO_CONTAINS_OTHER_THAN_NUMBERS_COMMA_ERROR ="로또 번호 입력은 숫자와 콤마(,)로 구성되어야 합니다.";
    private final static String INPUT_BONUS_CONTAINS_OTHER_THAN_NUMBERS_ERROR ="보너스 번호 입력은 숫자로 구성 되어야합니다.";
    private final static String LOTTO_NUMBER_MUST_BE_SIX_NUMBERS_ERROR = "로또 번호는 6개 입력해주세요.";
    private final static String DUPLICATED_LOTTO_NUMBER_ERROR = "번호 중에 중복 번호가 있습니다.";
    private final static String LOTTO_NUMBERS_OUT_OF_RANGE = "로또의 범위는 1~45입니다.";
    private final static String DUPLICATED_BONUS_NUMBER = "보너스 번호가 중복됩니다.";
    
    
    public void validateLottoNumbers(List<Integer> lottoNumbers) {
    	validateLottoNumbersListLength(lottoNumbers);
    	validateRepeatedLottoNumbers(lottoNumbers);
    	validateLottoNumbersRange(lottoNumbers);
    } 
	public void validateInputBonusNumbers(List<Integer> lottoNumbers, int inputBonusNumber) {
		validateBonusNumberRange(inputBonusNumber);
		validateRepeatedBonusNumber(lottoNumbers, inputBonusNumber);
	}
	public void validateLottoNumbersListLength(List<Integer> lottoNumbers) {
		if(lottoNumbers.size() != MAX_RANGE_OF_LOTTO_LENGTH) {
			throw new IllegalArgumentException(ERROR + );
		}
	}
}
