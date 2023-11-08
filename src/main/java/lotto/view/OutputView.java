package lotto.view;

import lotto.util.IOMessage;

import java.util.List;

public class OutputView {
	public static void printInputPurchaseAmountMessage() {
		System.out.println(IOMessage.INPUT_PURCHASE_AMOUNT_MESSAGE);
	}

	public static void printInputWinningNumberMessage() {
		System.out.println(IOMessage.INPUT_WINNING_NUMBER_MESSAGE);
	}

	public static void printInputBonusNumberMessage() {
		System.out.println(IOMessage.INPUT_BONUS_NUMBER_MESSAGE);
	}

	public static void printLotto(List<Integer> lotto) {
		printMessage(lotto.toString());
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
