package lotto.view;

import static lotto.constants.MessageConstants.INPUT_BONUS_NUMBER;
import static lotto.constants.MessageConstants.INPUT_PURCHASE_AMOUT;
import static lotto.constants.MessageConstants.INPUT_WINNING_NUMBER;
import static lotto.validator.InputException.checkBlank;
import static lotto.validator.InputException.checkComma;
import static lotto.validator.InputException.checkNull;
import static lotto.validator.InputException.checkNumber;
import static lotto.validator.InputException.checkOutOfNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static int inputPurchaseAmout() {
		System.out.println(INPUT_PURCHASE_AMOUT);
		String buyAmount = Console.readLine();
		purchaseAmoutVlidate(buyAmount);
		System.out.println();
		int purchaseAmount = Integer.parseInt(buyAmount);
		return purchaseAmount;
	}

	public static String inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER);
		String winningNumber = Console.readLine();
		WinningNumberValidate(winningNumber);
		System.out.println();
		return winningNumber;
	}

	public static String inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		String bonusNumber = Console.readLine();
		System.out.println();
		return bonusNumber;
	}

	private static void purchaseAmoutVlidate(String buyAmount) {
		checkNull(buyAmount);
		checkBlank(buyAmount);
		checkOutOfNumber(buyAmount);
	}

	private static void WinningNumberValidate(String winningNumber) {
		checkNull(winningNumber);
		checkBlank(winningNumber);
		checkNumber(winningNumber);
		checkComma(winningNumber);
	}

}
