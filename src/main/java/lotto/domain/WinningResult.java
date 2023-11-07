package lotto.domain;

import static lotto.constant.LottoConstant.*;
import static lotto.exception.ErrorMessage.*;
import static lotto.view.OutputView.*;

import java.util.List;

public class WinningResult {
	private final Lotto winningLotto;
	private final int bonusNumber;

	public WinningResult(Lotto winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		validate(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return winningLotto.getNumbers();
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private void validate(int bonusNumber) {
		try {
			validateRange(bonusNumber);
			validateDuplication(bonusNumber);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			throw e;
		}
	}

	private void validateRange(int bonusNumber) throws IllegalArgumentException {
		if (bonusNumber < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < bonusNumber) {
			throw new IllegalArgumentException(RANGE_ERROR.getMessage());
		}
	}

	private void validateDuplication(int bonusNumber) throws IllegalArgumentException {
		if (this.winningLotto.contains(bonusNumber)) {
			throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
		}
	}
}
