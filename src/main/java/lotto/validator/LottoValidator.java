package lotto.validator;

import java.util.StringTokenizer;

public interface LottoValidator {

	int validatePrice(String price);

	void validateWinningNumber(StringTokenizer numberSplitter);
}
