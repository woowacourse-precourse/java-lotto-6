package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;

import lotto.domain.StatisticsMachine;

public class Log {

	private static final String PRINT_MATCH_RANK = "%d개 일치 (%s원) - %d개\n";
	private static final String PRINT_MATCH_RANK_AND_BONUS_NUMBER = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
	private static final String PRINT_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
	private static final String FORMAT_WON_UNIT = "###,###";
	private static final DecimalFormat format = new DecimalFormat(FORMAT_WON_UNIT);

	public static void println(String message) {
		System.out.println(message);
	}

	public static void printStatistics(StatisticsMachine statisticsMachine) {
		Arrays.stream(Rank.values())
			.filter(rank -> !rank.equals(Rank.NO_RANK))
			.forEach(rank ->
				printMatchRank(rank, statisticsMachine));
		System.out.printf(PRINT_YIELD_MESSAGE, statisticsMachine.matchPercent());
	}

	private static void printMatchRank(Rank rank, StatisticsMachine statisticsMachine) {
		String message = PRINT_MATCH_RANK;
		if (rank.matchBonusNumber()) {
			message = PRINT_MATCH_RANK_AND_BONUS_NUMBER;
		}
		System.out.printf(message, rank.matchCount(), format(rank.getPrice()),
			statisticsMachine.countRank(rank));
	}

	private static String format(int price) {
		return format.format(price);
	}
}
