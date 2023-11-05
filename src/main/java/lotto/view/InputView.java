package lotto.view;

import static lotto.constants.MessageConstants.INPUT_BONUS_NUMBER;
import static lotto.constants.MessageConstants.INPUT_PURCHASE_AMOUT;
import static lotto.constants.MessageConstants.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BuyAmount;

public class InputView {

	public static int inputPurchaseAmout() {
		System.out.println(INPUT_PURCHASE_AMOUT);
		String buyAmount = Console.readLine();
		BuyAmount.validate(buyAmount);
		System.out.println();
		int purchaseAmount = Integer.parseInt(buyAmount);
		return purchaseAmount;
	}

	public static String inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER);
		String winnigNumber = Console.readLine();
		System.out.println();
		return winnigNumber;
	}

	public static String inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		String bonusNumber = Console.readLine();
		System.out.println();
		return bonusNumber;
	}

}
