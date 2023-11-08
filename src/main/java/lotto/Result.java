package lotto;

import static lotto.LottoGame.*;
import static lotto.Rank.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
	private List<Lotto> lottos;
	private Winner winner;
	private int money;
	private int prizeMoney = 0;
	private Map<Rank, Integer> countMap;

	public Result(List<Lotto> lottos, Winner winner, int money) {
		this.lottos = lottos;
		this.winner = winner;
		this.money = money;
		this.countMap = createCountMap();
		calculatePrizeMoney(lottos, winner);
		show();
	}

	private Map<Rank, Integer> createCountMap() {
		Map<Rank, Integer> map = new HashMap<>();
		for (Rank rank : Rank.values()) {
			map.put(rank, 0);
		}
		return map;
	}

	private void calculatePrizeMoney(List<Lotto> lottos, Winner winner) {
		for (Lotto lotto : lottos) {
			prizeMoney += lottoCompareTOWinner(lotto, winner);
		}
	}

	private int lottoCompareTOWinner(Lotto lotto, Winner winner) {
		List<Integer> matchList = new ArrayList<>(lotto.getNumbers());
		matchList.retainAll(winner.getNumbers());

		if (matchList.size() == 3)
			return bePicked(Rank.FIFTH_PLACE);
		if (matchList.size() == 4)
			return bePicked(FOURTH_PLACE);
		if (matchList.size() == 5 && lotto.getNumbers().contains(winner.getNumbers()))
			return bePicked(SECOND_PLACE);
		if (matchList.size() == 5)
			return bePicked(THIRD_PLACE);
		if (matchList.size() == 6)
			return bePicked(Rank.FIRST_PLACE);
		return 0;
	}

	private void show() {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + countMap.get(FIFTH_PLACE) + "개");
		System.out.println("4개 일치 (50,000원) - " + countMap.get(FOURTH_PLACE) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + countMap.get(THIRD_PLACE) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countMap.get(SECOND_PLACE) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + countMap.get(FIRST_PLACE) + "개");
		System.out.println("총 수익률은 " + calculateRateOfReturn() + "%입니다.");
	}

	private String calculateRateOfReturn() {
		double rateOfReturn = ((double)prizeMoney / (double)(money * MONEY_UNIT)) * 100;
		return String.format("%.1f", rateOfReturn);
	}

	private int bePicked(Rank rank) {
		countMap.put(rank, countMap.get(rank) + 1);
		return rank.getPrizeMoney();
	}
}
