package lotto.validator;

import java.util.StringTokenizer;

import lotto.Lotto;

public interface LottoValidator {

	void validatePrice(String price);

	void validateWinningNumber(StringTokenizer numberSplitter, Lotto lotto);

	void validateBonusNumber(String bonusNumber);
}
