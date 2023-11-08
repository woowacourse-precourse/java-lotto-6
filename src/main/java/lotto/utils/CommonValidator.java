package lotto.utils;

import java.util.List;
import java.util.StringTokenizer;

public interface CommonValidator {

	int validatePrice(String price);
	void validateWinningNumber(StringTokenizer numberSplitter, List<Integer> lotto);
	int validateBonusNumber(String bonusNumber);
}
