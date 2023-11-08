package lotto;

import static lotto.LottoGame.*;

import java.util.ArrayList;
import java.util.List;

public class Result {
	List<Lotto> lottos;
	Winner winner;
	int money;
	int prizeMoney = 0;

	public Result(List<Lotto> lottos, Winner winner, int money) {
		this.lottos = lottos;
		this.winner = winner;
		this.money = money;
		calculatePrizeMoney(lottos, winner);
		show();
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
			return Rank.FIFTH_PLACE.bePicked();
		if (matchList.size() == 4)
			return Rank.FOURTH_PLACE.bePicked();
		if (matchList.size() == 5 && lotto.getNumbers().contains(winner.getNumbers()))
			return Rank.SECOND_PLACE.bePicked();
		if (matchList.size() == 5)
			return Rank.THIRD_PLACE.bePicked();
		if (matchList.size() == 6)
			return Rank.FIRST_PLACE.bePicked();
		return 0;
	}

	void show() {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + Rank.FIFTH_PLACE.getCount() + "개");
		System.out.println("4개 일치 (50,000원) - " + Rank.FOURTH_PLACE.getCount() + "개");
		System.out.println("5개 일치 (1,500,000원) - " + Rank.THIRD_PLACE.getCount() + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Rank.SECOND_PLACE.getCount() + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + Rank.FIRST_PLACE.getCount() + "개");
		System.out.println("총 수익률은 " + calculateRateOfReturn() + "%입니다.");
	}

	private String calculateRateOfReturn() {
		double rateOfReturn = ((double)prizeMoney /(double) (money * MONEY_UNIT)) * 100;
		return String.format("%.1f", rateOfReturn);
	}
}
