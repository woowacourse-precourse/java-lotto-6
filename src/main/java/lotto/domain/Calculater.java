package lotto.domain;

import java.util.List;

public class Calculater {

	public static int buyCount(int buyAmount) {

		int lottoCount = buyAmount / 1000;
		return lottoCount;
	}

	public static int profitability(List<Rank> lottoRanks) {
		int totalWinngs = 0;
		for (Rank rank : lottoRanks) {
			totalWinngs += rank.getWinning();
		}
		return totalWinngs;
	}

	public static double revenue(int totalWinnings, int buyAmount) {

		double result = (double) totalWinnings / buyAmount * 100;

		return Math.round(result * 10) / 10.0;
	}

}
