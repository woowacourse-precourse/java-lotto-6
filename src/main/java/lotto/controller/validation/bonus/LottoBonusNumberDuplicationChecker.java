package lotto.controller.validation.bonus;

import static lotto.model.constant.IntegerSymbolicConstantEnum.BONUS_FREQUENCY_MAX_VALUE;

import java.util.Collections;
import lotto.model.lotto.Lotto;

public class LottoBonusNumberDuplicationChecker {
	public void checkLottoBonusNumberDuplication(Lotto lotto, String scannedLottoBonusNumberString) {
		Integer lottoBonusNumber = Integer.parseInt(scannedLottoBonusNumberString);
		if (BONUS_FREQUENCY_MAX_VALUE.getValue() < Collections.frequency(lotto.getNumbers(),lottoBonusNumber)){
			throw new IllegalArgumentException();
		}
	}
}
