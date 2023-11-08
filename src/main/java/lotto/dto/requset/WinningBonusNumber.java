package lotto.dto.requset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lotto.view.ExceptionText;

public class WinningBonusNumber {

	String winningNumber;

	String bonusNumber;

	public String getWinningNumber() {
		return winningNumber;
	}

	public void setWinningNumber(String winningNumber) {
		validateWinningInput(winningNumber);
		this.winningNumber = winningNumber;
	}

	public String getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(String bonusNumber) {
		checkWinningNumber();
		checkInputIsEmpty(bonusNumber);
		ScopeCheck(Integer.parseInt(bonusNumber));
		checkForOverlap(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	private void checkWinningNumber() {
		if(this.winningNumber == null) {
			throw new IllegalStateException(ExceptionText.WINNING_NUMBERS_NULL.getText());
		}
	}

	private void validateWinningInput(String winningNumber) {
		checkInputIsEmpty(winningNumber);
		String[] parts = winningNumber.split(",");
		numbersCountCheck(parts);
		Set<Integer> uniqueNumbers = new HashSet<>();
		for (String part : parts) {
			numbersCheck(uniqueNumbers, part);
		}
	}

	private static void checkInputIsEmpty(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException(ExceptionText.EMPTY.getText());
		}
	}
	private static void numbersCountCheck(String[] parts) {
		if (parts.length != 6) {
			throw new IllegalArgumentException(ExceptionText.DIFFERENT_NUMBER.getText());
		}
	}

	private static void numbersCheck(Set<Integer> uniqueNumbers, String part) {
		try {
			int number = Integer.parseInt(part);
			ScopeCheck(number);
			DuplicateCheck(uniqueNumbers, number);
			uniqueNumbers.add(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionText.INPUT_NUMBER_ERROR.getText());

		}
	}
	private static void ScopeCheck(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException(ExceptionText.BEYOND_SCOPE.getText());
		}
	}

	private static void DuplicateCheck(Set<Integer> uniqueNumbers, int number) {
		if (uniqueNumbers.contains(number)) {
			throw new IllegalArgumentException(ExceptionText.DUPLICATE_NUMBERS.getText());
		}
	}
	public void checkForOverlap(String bonusNumber) {
		String[] winningNumbers = this.winningNumber.split(",");
		String[] bonusNumbers = bonusNumber.split(",");

		Set<String> winningSet = new HashSet<>(Arrays.asList(winningNumbers));
		Set<String> bonusSet = new HashSet(Arrays.asList(bonusNumbers));

		winningSet.retainAll(bonusSet);

		if (!winningSet.isEmpty()) {
			throw new IllegalArgumentException(ExceptionText.DUPLICATE_WIN_BONUS.getText());
		}
	}

}
