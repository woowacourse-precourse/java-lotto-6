package lotto.output;

import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lotto.constant.Prize;

public class ResultPrinter {

	private static final String PURCHASE_TIME_MESSAGE = "개를 구매했습니다.";
	private static final String SUMMARY_MESSAGE = "\n당첨 통계\n";
	private static final String SUMMARY_MESSAGE_SEPARATOR = "---";
	private static final String SUMMARY_MESSAGE_FORMAT = "%s (%,d원) - %d개\n";
	private static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
	private static final int PERCENT = 100;

	public static void printLottos(List<Lotto> lottos, int purchaseTime) {

		System.out.println();
		System.out.println(purchaseTime + PURCHASE_TIME_MESSAGE);

		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers());
		}

	}

	public static void printSummary(Map<String, Integer> summary) {

		System.out.printf(SUMMARY_MESSAGE);
		System.out.println(SUMMARY_MESSAGE_SEPARATOR);

		for (Prize prize : Prize.values()) {

			String hitCount = prize.getHitResult();
			long money = prize.getMoney();
			int count = summary.get(hitCount);

			System.out.printf(SUMMARY_MESSAGE_FORMAT, hitCount, money, count);
		}
	}

	public static void printYield(double yield) {
		System.out.printf(YIELD_MESSAGE_FORMAT, yield * PERCENT);
	}

}