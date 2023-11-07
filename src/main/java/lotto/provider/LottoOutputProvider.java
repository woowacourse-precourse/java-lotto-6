package lotto.provider;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;

public class LottoOutputProvider {

	public void getOutputBuyLotto(List<Lotto> lottos) {
		lineBreak();
		System.out.println(lottos.size() + "개를 구매했습니다.");
		lottos.forEach(lotto ->
			System.out.println(lotto.toString()));
		lineBreak();
	}

	public void getOutputTotalStatistics(Map<WinningRank, Integer> statisticsMap, int price) {
		lineBreak();

		int totalReward = statisticsMap.entrySet().stream()
			.mapToInt(entry -> entry.getKey().getProfit() * entry.getValue())
			.sum();

		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + statisticsMap.get(WinningRank.FIFTH) + "개");
		System.out.println("4개 일치 (50,000원) - " + statisticsMap.get(WinningRank.FOURTH) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + statisticsMap.get(WinningRank.THIRD) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statisticsMap.get(WinningRank.SECOND) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + statisticsMap.get(WinningRank.FIRST) + "개");
		System.out.println("총 수익률은" + String.format("%.1f%%",totalReward/(double)price * 100) + "입니다.");

	}

	private void lineBreak() {
		System.out.println();
	}


}
