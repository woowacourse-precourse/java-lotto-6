package lotto.view;

import static lotto.constants.MessageConstants.INPUT_BONUS_NUMBER;
import static lotto.constants.MessageConstants.INPUT_PURCHASE_AMOUT;
import static lotto.constants.MessageConstants.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static int inputPurchaseAmout() {
		System.out.println(INPUT_PURCHASE_AMOUT);
		int purchaseAmount = Integer.parseInt(Console.readLine());
		return purchaseAmount;
	}

	public static String inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER);

		return null;
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);

		return 0;
	}

}
