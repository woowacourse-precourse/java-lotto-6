package lotto.view;

import static lotto.config.GameGuideMessage.INPUT_BONUS_NUMBER;
import static lotto.config.GameGuideMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.config.GameGuideMessage.INPUT_WINNING_NUMBERS;
import static lotto.config.GameGuideMessage.NUMBER_OF_TICKETS_PURCHASED;
import static lotto.config.GameGuideMessage.SHOW_RATE_OF_RETURN;
import static lotto.config.GameGuideMessage.WINNING_STATISTICS;

import java.util.Map;
import lotto.config.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoPlayer;
import lotto.domain.LottoResult;

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

	public static void printWinningStatistics(LottoResult lottoResult) {
		StringBuilder stringBuilder = new StringBuilder();
		Map<LottoRank, Integer> rankResult = lottoResult.getRankResult();
		LottoRank[] ranks = LottoRank.values();

		stringBuilder.append(WINNING_STATISTICS.getMessage()).append("\n");

		for (LottoRank rank : ranks) {
			String message = rank.getWinningMessage().formatted(rankResult.getOrDefault(rank, 0));
			stringBuilder.append(message).append("\n");
		}

		stringBuilder.append(SHOW_RATE_OF_RETURN.getMessage().formatted(lottoResult.calculateReturnRate()));
		System.out.println(stringBuilder);
	}
}