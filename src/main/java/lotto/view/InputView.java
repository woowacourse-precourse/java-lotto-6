package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoNumberValidator;
import lotto.util.PurchaseValidator;

import java.util.List;
import java.util.Arrays;

public class InputView {
	public static int inputPurchaseAmount() {
		OutputView.printInputPurchaseAmountMessage();
		String purchaseAmount = Console.readLine();
		PurchaseValidator.validatePurchaseAmount(purchaseAmount);

		return Integer.parseInt(purchaseAmount);
	}

	public static List<Integer> inputWinningNumber() {
		OutputView.printInputWinningNumberMessage();
		String winningNumber = Console.readLine();
		LottoNumberValidator.validateLottoNumber(winningNumber);

		return Arrays.stream(winningNumber.split(","))
				.map(Integer::parseInt)
				.toList();
	}

	public static int inputBonusNumber() {
		OutputView.printInputBonusNumberMessage();
		String bonusNumber = Console.readLine();

		return Integer.parseInt(bonusNumber);
	}
}
