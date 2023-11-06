package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumberMaker;
import lotto.validation.NumbersValidation;

public class InputMachine {

	private static final String SEPARATOR = ",";
	private static final String PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
	private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	public static String inputPurchaseAmount() {

		System.out.println(PURCHASE_MESSAGE);
		String purchaseAmount = Console.readLine();

		NumbersValidation.validateOnlyNumber(purchaseAmount);

		return purchaseAmount;

	}

	public static String inputWinningNumber() {

		System.out.println(WINNING_NUMBER_MESSAGE);
		String winningNumber = Console.readLine();

		validateSeparator(winningNumber);

		return winningNumber;
	}

	private static void validateSeparator(String inputNumber) {

		if (!inputNumber.contains(SEPARATOR)) {
			throw new IllegalArgumentException("구분자(,)만을 이용해 나눠주세요");
		}

	}

	public static String inputBonusNumber() {

		System.out.println(BONUS_NUMBER_MESSAGE);
		String bonusNumber = Console.readLine();

		NumbersValidation.validateOnlyNumber(bonusNumber);

		return bonusNumber;
	}


}