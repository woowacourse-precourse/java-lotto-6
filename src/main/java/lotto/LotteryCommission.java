package lotto;

import java.util.List;

public class LotteryCommission {
	private List<Integer> winningNumbers;
	private Integer bonusNumber;

	public LotteryCommission(List<Integer> winningNumbers) {
		validateWinningNumbers(winningNumbers);
		this.winningNumbers = winningNumbers;
	}

	private void validateWinningNumbers(List<Integer> winningNumbers) {
		if (winningNumbers.size() != Constants.WINNING_NUMBER_LENGTH) {
			throw new IllegalArgumentException("[ERROR] " + Constants.WINNING_NUMBER_LENGTH + "개를 입력해야 합니다!");
		}

		if (winningNumbers.stream().distinct().toList().size() < Constants.WINNING_NUMBER_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다!");
		}

		for (Integer number : winningNumbers) {
			if (number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER) {
				throw new IllegalArgumentException("[ERROR] 1-45 사이의 숫자만 입력할 수 없습니다!");
			}
		}
	}

	private void validateBonusNumber(Integer bonusNumber) {
		if (bonusNumber < Constants.LOTTO_MIN_NUMBER || bonusNumber > Constants.LOTTO_MAX_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 1-45 사이의 숫자만 입력할 수 없습니다!");
		}

		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다!");
		}
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public void setBonusNumber(Integer bonusNumber) {
		validateBonusNumber(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}
}
