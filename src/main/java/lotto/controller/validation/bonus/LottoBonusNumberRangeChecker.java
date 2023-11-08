package lotto.controller.validation.bonus;

import static lotto.model.constant.IntegerSymbolicConstantEnum.MAX_NUMBER_FOR_LOTTO_NUMBERS;
import static lotto.model.constant.IntegerSymbolicConstantEnum.MIN_NUMBER_FOR_LOTTO_NUMBERS;

public class LottoBonusNumberRangeChecker {
	Integer minValue = MIN_NUMBER_FOR_LOTTO_NUMBERS.getValue();
	Integer maxValue = MAX_NUMBER_FOR_LOTTO_NUMBERS.getValue();
	public void checkLottoBonusNumberRange(String scannedLottoBonusNumberString) {
		if (Integer.parseInt(scannedLottoBonusNumberString) < minValue){
			throw new IllegalArgumentException();
		}
		if (Integer.parseInt(scannedLottoBonusNumberString) > maxValue){
			throw new IllegalArgumentException();
		}
	}
}
