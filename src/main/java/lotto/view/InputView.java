package lotto.view;

import static lotto.constants.MessageConstants.INPUT_BONUS_NUMBER;
import static lotto.constants.MessageConstants.INPUT_PURCHASE_AMOUT;
import static lotto.constants.MessageConstants.INPUT_WINNING_NUMBER;
import static lotto.domain.conversion.changeNumbers;
import static lotto.validator.InputException.checkBlank;
import static lotto.validator.InputException.checkComma;
import static lotto.validator.InputException.checkDuplication;
import static lotto.validator.InputException.checkEmpty;
import static lotto.validator.InputException.checkNumber;
import static lotto.validator.InputException.checkOutOfNumber;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Lotto;

public class InputView {
	static List<Integer> winningNums;

	public static int inputPurchaseAmout() {
		System.out.println(INPUT_PURCHASE_AMOUT);
		String buyAmount = Console.readLine();
		purchaseAmoutVlidate(buyAmount);
		System.out.println();
		int purchaseAmount = Integer.parseInt(buyAmount);
		return purchaseAmount;
	}

	public static List<Integer> inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER);
		String winningNumber = Console.readLine();
		winningNums = changeNumbers(winningNumber);
		Lotto lotto = new Lotto(winningNums);
		winningNumberValidate(winningNumber);
		System.out.println();
		return winningNums;
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		String bonusNumber = Console.readLine();
		int bonusNum = Integer.parseInt(bonusNumber);
		bonusNumberValidate(bonusNumber, bonusNum, winningNums);
		System.out.println();
		return bonusNum;
	}

	private static void bonusNumberValidate(String bonusNumber, int bonusNum, List<Integer> winningNums) {
		checkEmpty(bonusNumber);
		checkBlank(bonusNumber);
		checkNumber(bonusNumber);
		checkDuplication(bonusNum, winningNums);
	}

	private static void purchaseAmoutVlidate(String buyAmount) {
		checkEmpty(buyAmount);
		checkBlank(buyAmount);
		checkOutOfNumber(buyAmount);
	}

	private static void winningNumberValidate(String winningNumber) {
		checkEmpty(winningNumber);
		checkBlank(winningNumber);
		checkNumber(winningNumber);
		checkComma(winningNumber);
	}

}
