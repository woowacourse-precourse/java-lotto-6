package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.exception.WinnerLottoExceptionMessage.DUPLICATED_NUMBER_BETWEEN_WINNER_NUMBER_AND_BONUS_NUMBER;

public class WinnerLotto {

	private final List<Integer> winnerNumbers;
	private final Integer bonusNumber;

	private WinnerLotto(final List<Integer> winnerNumbers,
		final Integer bonusNumber) {
		validateDuplicatedNumberBetweenWinnerNumbersAndBonusNumber(winnerNumbers, bonusNumber);
		this.winnerNumbers = winnerNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinnerLotto create(final List<Integer> winnerNumbers,
		final Integer bonusNumber) {
		return new WinnerLotto(winnerNumbers,
			bonusNumber);
	}

	private void validateDuplicatedNumberBetweenWinnerNumbersAndBonusNumber(
		final List<Integer> winnerNumbers, final Integer bonusNumber) {
		if (winnerNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(
				DUPLICATED_NUMBER_BETWEEN_WINNER_NUMBER_AND_BONUS_NUMBER.getMessage());
		}
	}


	public List<Integer> getWinnerNumbers() {
		return Collections.unmodifiableList(winnerNumbers);
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}


}
