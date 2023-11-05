package lotto.view;

import static lotto.config.GameGuideMessage.INPUT_BONUS_NUMBER;
import static lotto.config.GameGuideMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.config.GameGuideMessage.INPUT_WINNING_NUMBERS;
import static lotto.config.GameGuideMessage.NUMBER_OF_TICKETS_PURCHASED;

import lotto.domain.Lotto;
import lotto.domain.LottoPlayer;

public class OutputView {

	public static void askPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
	}

	public static void printPlayerLottos(LottoPlayer lottoPlayer) {
		System.out.println();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(NUMBER_OF_TICKETS_PURCHASED.getMessage().formatted(lottoPlayer.getPurchasedLottos().size())).append("\n");

		for (Lotto lotto : lottoPlayer.getPurchasedLottos()) {
			stringBuilder.append(lotto.getNumbers()).append("\n");
		}

		System.out.println(stringBuilder);
	}

	public static void askWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS.getMessage());
	}

	public static void askBonusNumber() {
		System.out.println();

		System.out.println(INPUT_BONUS_NUMBER.getMessage());
	}
}