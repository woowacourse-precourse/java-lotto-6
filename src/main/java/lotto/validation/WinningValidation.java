package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningValidation {
	public static void isWinningCorrect(List<Integer> winning) {
		LottoValidation.isLottoCorrect(winning);
	}
	
	public static void isBonusCorrect(int bonus, List<Integer> winning) {
		LottoValidation.checkRange(bonus);
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		uniqueNumbers.addAll(winning);
		LottoValidation.checkDuplicate(bonus, uniqueNumbers);
	}
}