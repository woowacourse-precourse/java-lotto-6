package lotto.dataObjects;

import java.util.List;

import lotto.enumContainer.ErrorOperation;
import lotto.enumContainer.LottoResult;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateDupliCate(numbers);
		validateSizeOfCollection(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			ErrorOperation.COLLECTION_SIZE_ERROR.apply();
		}
	}

	private void validateDupliCate(List<Integer> numbers) {
		boolean isDuplicate = numbers.stream()
			.distinct()
			.toList()
			.size() != 6;
		if (isDuplicate) {
			ErrorOperation.SELF_DUPLICATE_ERROR.apply();
		}
	}

	private void validateSizeOfCollection(List<Integer> numbers) {
		if (numbers.size() != 6) {
			ErrorOperation.COLLECTION_SIZE_ERROR.apply();
		}
	}

	public void validateDuplicateWithBonus(int number) {
		if (numbers.contains(number)) {
			ErrorOperation.BONUS_DUPLICATE_ERROR.apply();
		}
	}

	public void checkLotto(int bonusNumber, List<List<Integer>> issuedLotto, Money money) {
		for (List<Integer> lotto : issuedLotto) {
			int matchNumbersCount = WinningCheck(lotto);
			boolean isBonus = bonusCheck(bonusNumber, lotto);
			reflectResult(matchNumbersCount, isBonus, money);
		}
	}

	private boolean bonusCheck(int bonusNumber, List<Integer> lotto) {
		return lotto.contains(bonusNumber);
	}

	private int WinningCheck(List<Integer> lotto) {
		return (int) lotto.stream().filter(numbers::contains).count();
	}

	private void  reflectResult(int matchNumbersCount, boolean isBonus, Money money) {
		if (matchNumbersCount == LottoResult.FIVE.number && isBonus) {
			LottoResult.FIVE_BONUS.reflectResult(money);
			return;
		}
		for (LottoResult matchType : LottoResult.values()) {
			if (matchType.number == matchNumbersCount) {
				matchType.reflectResult(money);
				break;
			}
		}

	}
}
