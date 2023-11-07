package lotto.printer;

import java.util.List;

import lotto.lotto.Lotto;

public class ConsoleLottoPrinter implements LottoPrinter {
	private static final String OPENING_SQUARE_BRACKET = "[";
	private static final String CLOSING_SQUARE_BRACKET = "]";
	private static final String COMMA_WITH_SPACE = ", ";
	private static final String ENTER = "\n";

	@Override
	public void askInputPurchasePrice() {
		System.out.println(PrintMessage.ASK_INPUT_PURCHASE_PRICE.getMessage());
	}

	@Override
	public void noticePurchaseLotto(List<Lotto> purchasedLottos) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(purchasedLottos.size()).append(PrintMessage.NOTICE_PURCHASE);

		for (Lotto lotto : purchasedLottos) {
			stringBuilder.append(OPENING_SQUARE_BRACKET);
			for (int number : lotto.getNumbers()) {
				stringBuilder.append(number).append(COMMA_WITH_SPACE);
			}
			stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
			stringBuilder.append(CLOSING_SQUARE_BRACKET).append(ENTER);
		}

		System.out.println(stringBuilder);
	}

	@Override
	public void askWinningNumber() {
		System.out.println(PrintMessage.ASK_WINNING_NUMBER);
	}

	@Override
	public void askBonusNumber() {
		System.out.println(PrintMessage.ASK_BONUS_NUMBER);
	}

	@Override
	public void noticeResult(List<Integer> results, Double returnRate) {

	}
}
