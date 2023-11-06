package lotto.utils;

import java.util.List;
import java.util.StringTokenizer;

public interface LottoValidator {

	int validatePrice(String price);

	List<Integer> validateWinningNumber(StringTokenizer numberSplitter, List<Integer> lotto);

	void validateBonusNumber(String bonusNumber);
}
