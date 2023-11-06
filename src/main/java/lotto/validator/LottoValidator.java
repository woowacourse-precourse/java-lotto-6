package lotto.validator;

import java.util.StringTokenizer;

import lotto.Lotto;

public interface LottoValidator {

	int validatePrice(String price);

	void validateWinningNumber(StringTokenizer numberSplitter, Lotto lotto);
}
