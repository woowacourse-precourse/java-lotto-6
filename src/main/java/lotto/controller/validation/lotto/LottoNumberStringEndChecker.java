package lotto.controller.validation.lotto;

import static lotto.model.constant.CharSymbolicConstantEnum.UNALLOWED_LAST_CHAR;

public class LottoNumberStringEndChecker {

	public void checkLottoNumberStringEnd(char lastChar) {
		if (lastChar == UNALLOWED_LAST_CHAR.getValue()){
			throw new IllegalArgumentException();
		}
	}
}
