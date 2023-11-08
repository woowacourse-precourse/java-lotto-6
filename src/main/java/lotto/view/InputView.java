package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;

public class InputView {
	public static int inputPurchaseAmount() {
		OutputView.printInputPurchaseAmountMessage();
		String purchaseAmount = Console.readLine();

		return Integer.parseInt(purchaseAmount);
	}

	public static List<Integer> inputWinningNumber() {
		OutputView.printInputWinningNumberMessage();
		String winningNumber = Console.readLine();

		return Arrays.stream(winningNumber.split(","))
				.map(Integer::parseInt)
				.toList();
	}
}
