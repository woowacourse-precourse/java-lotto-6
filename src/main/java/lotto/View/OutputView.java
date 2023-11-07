//OutputView.java
package lotto.View;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import lotto.Enum.Prize;
import lotto.Lotto;

public class OutputView {
	public static void printPurchasedMessage(int lottoCount, List<Lotto> lottos) {
		printLottoCount(lottoCount);
		printLottos(lottos);
	}

	private static void printLottoCount(int lottoCount) {
		System.out.printf("\n%d개를 구매했습니다.\n", lottoCount);
	}

	private static void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.toString());
		}
	}

	public static void printResult(Map<Prize, Integer> prizes, double profitRate) {
		System.out.println("\n당첨 통계\n---");
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
			if(isMatchBonus){
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
		System.out.printf("총 수익률은 %s%%입니다.", formattedProfitRate);
	}

	private static String formatMatchCount(int matchCount){
		return String.format("%d개 일치", matchCount);
	}

	private static String formatMatchBonus(){
		return ", 보너스 볼 일치";
	}

	private static String formatMoney(int money){
		return String.format(" (%,d원)", money);
	}

	private static String formatCount(int count){
		return String.format(" - %d개", count);
	}
}
