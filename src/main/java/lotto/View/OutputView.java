//OutputView.java
package lotto.View;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import lotto.Enum.Prize;
import lotto.Lotto;

public class OutputView {
	private static final String PURCHASED_MESSAGE = "\n%d개를 구매했습니다.\n";
	private static final String RESULT_HEADER = "\n당첨 통계\n---";
	private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %s%%입니다.";

	private static final String MATCH_COUNT_FORMAT = "%d개 일치";
	private static final String MATCH_BONUS_FORMAT = ", 보너스 볼 일치";
	private static final String MONEY_FORMAT = " (%,d원)";
	private static final String COUNT_FORMAT = " - %d개";
	public static void printPurchasedMessage(int lottoCount, List<Lotto> lottos) {
		printLottoCount(lottoCount);
		printLottos(lottos);
	}

	private static void printLottoCount(int lottoCount) {
		System.out.printf(PURCHASED_MESSAGE, lottoCount);
	}

	private static void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.toString());
		}
	}

	public static void printResult(Map<Prize, Integer> prizes, double profitRate) {
		System.out.println(RESULT_HEADER);
		printPrizeResults(prizes);
		printProfitRate(profitRate);
	}

	private static void printPrizeResults(Map<Prize, Integer> prizes) {
		for (Map.Entry<Prize, Integer> entry : prizes.entrySet()) {
			Prize prize = entry.getKey();
			int count = entry.getValue();
			int matchCount = prize.getCountMatch();
			boolean isMatchBonus = prize.getIsMatchBonus();
			int money = prize.getPrize();

			StringBuilder result = new StringBuilder();
			result.append(formatMatchCount(matchCount));
			if (isMatchBonus) {
				result.append(formatMatchBonus());
			}
			result.append(formatMoney(money));
			result.append(formatCount(count));

			System.out.println(result);
		}
	}

	private static void printProfitRate(double profitRate){
		DecimalFormat df = new DecimalFormat("0.##");
		String formattedProfitRate = df.format(profitRate);
		System.out.printf(PROFIT_RATE_MESSAGE, formattedProfitRate);
	}

	private static String formatMatchCount(int matchCount){
		return String.format( MATCH_COUNT_FORMAT, matchCount) ;
	}

	private static String formatMatchBonus(){
		return MATCH_BONUS_FORMAT;
	}

	private static String formatMoney(int money){
		return String.format(MONEY_FORMAT, money);
	}

	private static String formatCount(int count){
		return String.format(COUNT_FORMAT, count);
	}
}
