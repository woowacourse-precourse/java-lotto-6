package lotto.provider;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;

public class LottoOutputProvider {

	public void getOutputBuyLotto(List<Lotto> lottos) {
		lineBreak();
		System.out.println(lottos.size() + "개를 구매했습니다.");
		lottos.forEach(lotto -> System.out.println(lotto.toString()));
		lineBreak();
	}

	public void getOutputTotalStatistics(Map<WinningRank, Integer> statisticsMap, int price) {
		lineBreak();
		int totalReward = getTotalReward(statisticsMap);

		printStatistics(statisticsMap);
		System.out.println("총 수익률은 " + String.format("%.1f%%", totalReward / (double)price * 100) + "입니다.");

	}

	private void printStatistics(Map<WinningRank, Integer> statisticsMap) {
		System.out.println("당첨 통계");
		System.out.println("---");
		printSame("3개 일치 (5,000원)", WinningRank.FIFTH, statisticsMap);
		printSame("4개 일치 (50,000원)", WinningRank.FOURTH, statisticsMap);
		printSame("5개 일치 (1,500,000원)", WinningRank.THIRD, statisticsMap);
		printSame("5개 일치, 보너스 볼 일치 (30,000,000원)", WinningRank.SECOND, statisticsMap);
		printSame("6개 일치 (2,000,000,000원)", WinningRank.FIRST, statisticsMap);
	}

	private void printSame(String message, WinningRank winningRank, Map<WinningRank, Integer> statisticsMap) {
		System.out.println(message + " - " + statisticsMap.getOrDefault(winningRank, 0) + "개");
	}

	private int getTotalReward(Map<WinningRank, Integer> statisticsMap) {
		return statisticsMap.entrySet().stream()
			.mapToInt(entry -> entry.getKey().getProfit() * entry.getValue())
			.sum();
	}

	private void lineBreak() {
		System.out.println();
	}

}
