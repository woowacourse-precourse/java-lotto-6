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

	private static final String NEW_LINE = "\n";

	public static void askPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
	}

	public static void printPlayerLottos(LottoPlayer lottoPlayer) {
		StringBuilder stringBuilder = new StringBuilder();

		printLottoTickets(lottoPlayer, stringBuilder);
		printPlayerLottos(lottoPlayer, stringBuilder);

		System.out.println(stringBuilder);
	}

	private static void printLottoTickets(LottoPlayer lottoPlayer, StringBuilder stringBuilder) {
		stringBuilder.append(NEW_LINE);
		stringBuilder.append(NUMBER_OF_TICKETS_PURCHASED.getMessage().formatted(lottoPlayer.getLottos().size())).append("\n");
	}

	private static void printPlayerLottos(LottoPlayer lottoPlayer, StringBuilder stringBuilder) {
		for (Lotto lotto : lottoPlayer.getLottos()) {
			stringBuilder.append(lotto.getNumbers()).append(NEW_LINE);
		}
	}

	public static void askWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS.getMessage());
	}

	public static void askBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER.getMessage());
	}

	public static void printWinningStatistics(LottoResult lottoResult) {
		StringBuilder stringBuilder = new StringBuilder();
		Map<LottoRank, Integer> rankResult = lottoResult.getRankResult();
		LottoRank[] ranks = LottoRank.values();

		printWinningStatistics(stringBuilder, WINNING_STATISTICS.getMessage());
		printRankResult(stringBuilder, rankResult, ranks);
		printReturnRate(stringBuilder, lottoResult);

		System.out.println(stringBuilder);
	}

	private static void printWinningStatistics(StringBuilder stringBuilder, String WINNING_STATISTICS) {
		stringBuilder.append(NEW_LINE);
		stringBuilder.append(WINNING_STATISTICS).append(NEW_LINE);
	}

	private static void printReturnRate(StringBuilder stringBuilder, LottoResult lottoResult) {
		stringBuilder.append(SHOW_RATE_OF_RETURN.getMessage().formatted(lottoResult.calculateReturnRate()));
	}

	private static void printRankResult(StringBuilder stringBuilder, Map<LottoRank, Integer> rankResult, LottoRank[] ranks) {
		for (LottoRank rank : ranks) {
			String message = rank.getWinningMessage().formatted(rankResult.getOrDefault(rank, 0));
			stringBuilder.append(message).append(NEW_LINE);
		}
	}

	public static void printExceptionMessage(String message) {
		System.out.println(message);
	}
}