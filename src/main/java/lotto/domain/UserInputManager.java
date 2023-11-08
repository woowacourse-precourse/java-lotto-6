package lotto.domain;

import static lotto.domain.LottoGame.*;
import static lotto.domain.LottoNumber.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserInputManager {
	private final static String DELIMITER = ",";

	public static int inputPurchaseAmount() throws IllegalArgumentException {
		String userInput = Console.readLine();
		return checkPurchaseAmountIsValid(userInput);
	}

	private static int checkPurchaseAmountIsValid(String userInput) throws IllegalArgumentException {
		int purchaseAmount;

		purchaseAmount = getPurchaseAmount(userInput);

		checkPurchaseAmountIsBiggerThanLottoPrice(purchaseAmount);

		checkPurchaseAmountIsDividedByLottoPrice(purchaseAmount);

		return purchaseAmount;
	}

	private static void checkPurchaseAmountIsDividedByLottoPrice(int purchaseAmount) {
		if (purchaseAmount % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE + " 단위로 입력하세요.");
		}
	}

	private static void checkPurchaseAmountIsBiggerThanLottoPrice(int purchaseAmount) {
		if (purchaseAmount < LOTTO_PRICE) {
			throw new IllegalArgumentException("[ERROR] " + LOTTO_PRICE + " 이상의 숫자를 입력하세요.");
		}
	}

	private static int getPurchaseAmount(String userInput) {
		int purchaseAmount;
		try {
			purchaseAmount = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
		}
		return purchaseAmount;
	}

	public static List<Integer> inputWinningNumber() {
		String userInput = Console.readLine();
		return checkWinningNumberIsValid(userInput);
	}

	private static List<Integer> checkWinningNumberIsValid(String userInput) {
		List<Integer> winningNumber = new ArrayList<>();
		boolean[] numberUsed = new boolean[MAX_LOTTO_NUMBER.getValue() + 1];

		checkWinningNumberIsEmpty(userInput);

		checkWinningNumberHasNotNumber(userInput, winningNumber);

		checkWinningNumberConsistOfNumberOfLottoNumbers(winningNumber);

		checkWinningNumberHasNumberOutOfRange(winningNumber, numberUsed);

		return winningNumber;
	}

	private static void checkWinningNumberHasNumberOutOfRange(List<Integer> winningNumber, boolean[] numberUsed) {
		for (int number : winningNumber) {
			if (MIN_LOTTO_NUMBER.getValue() > number || MAX_LOTTO_NUMBER.getValue() < number) {
				throw new IllegalArgumentException(
					"[ERROR] " + MIN_LOTTO_NUMBER.getValue() + " 이상 " + MAX_LOTTO_NUMBER.getValue()
						+ " 이하의 숫자를 입력하세요.");
			}
			if (numberUsed[number]) {
				throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력하세요.");
			}
			numberUsed[number] = true;
		}
	}

	private static void checkWinningNumberConsistOfNumberOfLottoNumbers(List<Integer> winningNumber) {
		if (winningNumber.size() != NUMBER_OF_LOTTO_NUMBERS.getValue()) {
			throw new IllegalArgumentException("[ERROR] " + NUMBER_OF_LOTTO_NUMBERS.getValue() + "개의 숫자를 입력하세요.");
		}
	}

	private static void checkWinningNumberHasNotNumber(String userInput, List<Integer> winningNumber) {
		try {
			for (String number : userInput.split(DELIMITER)) {
				winningNumber.add(Integer.parseInt(number));
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 쉼표(',')로 구분하여 입력하세요.");
		}
	}

	private static void checkWinningNumberIsEmpty(String userInput) {
		if (userInput.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력하세요.");
		}
	}

	public static int inputBonusNumber(List<Integer> winningNumber) {
		String userInput = Console.readLine();
		return checkBonusNumberIsValid(userInput, winningNumber);
	}

	private static int checkBonusNumberIsValid(String userInput, List<Integer> winningNumber) {
		int bonusNumber;

		bonusNumber = getBonusNumber(userInput);

		checkBonusNumberIsInRange(bonusNumber);

		checkBonusNumberIsDuplicatedByWinningNumber(winningNumber, bonusNumber);

		return bonusNumber;
	}

	private static void checkBonusNumberIsDuplicatedByWinningNumber(List<Integer> winningNumber, int bonusNumber) {
		for (int number : winningNumber) {
			if (bonusNumber == number) {
				throw new IllegalArgumentException("[ERROR] 당첨 번호와 번호가 중복되었습니다.");
			}
		}
	}

	private static void checkBonusNumberIsInRange(int bonusNumber) {
		if (MIN_LOTTO_NUMBER.getValue() > bonusNumber || MAX_LOTTO_NUMBER.getValue() < bonusNumber) {
			throw new IllegalArgumentException(
				"[ERROR] " + MIN_LOTTO_NUMBER.getValue() + " 이상 " + MAX_LOTTO_NUMBER.getValue() + " 이하의 숫자를 입력하세요.");
		}
	}

	private static int getBonusNumber(String userInput) {
		int bonusNumber;
		try {
			bonusNumber = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
		}
		return bonusNumber;
	}

}
