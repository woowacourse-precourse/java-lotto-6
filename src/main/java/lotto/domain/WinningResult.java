package lotto.domain;

import static lotto.constant.LottoConstant.*;
import static lotto.exception.ErrorMessage.*;

public class WinningResult {
	private final Lotto winningLotto;
	private final int bonusNumber;

	public WinningResult(Lotto winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		validate(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public Lotto getWinningLotto() {
		return winningLotto;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private void validate(int bonusNumber) {
		validateRange(bonusNumber);
		validateDuplication(bonusNumber);
	}

	private void validateRange(int bonusNumber) {
		if (bonusNumber < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < bonusNumber) {
			throw new IllegalArgumentException(RANGE_ERROR.getMessage());
		}
	}

	private void validateDuplication(int bonusNumber) {
		if (this.winningLotto.contains(bonusNumber)) {
			throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
		}
	}
}
