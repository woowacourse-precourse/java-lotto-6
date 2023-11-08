package lotto.domain;

import java.util.Map;

public class Result {
	private final int purchaseAmount;
	private final Map<Rank, Integer> matchCount;
	private final float rateOfReturn;

	private Result(int purchaseAmount, Map<Rank, Integer> matchCount, float rateOfReturn) {
		this.purchaseAmount = purchaseAmount;
		this.matchCount = matchCount;
		this.rateOfReturn = rateOfReturn;
	}

	public static Result of(int purchaseAmount, Map<Rank, Integer> matchCount) {
		return new Result(purchaseAmount, matchCount, calculateRateOfReturn(purchaseAmount, matchCount));
	}

	public float getRateOfReturn() {
		return rateOfReturn;
	}

	public int getCount(Rank rank) {
		return matchCount.get(rank);
	}

	private static float calculateRateOfReturn(int purchaseAmount, Map<Rank, Integer> matchCount) {
		int total = matchCount.keySet().stream()
			.mapToInt(rank -> matchCount.get(rank) * rank.getReward())
			.sum();
		return (float)(Math.round((float)total / (purchaseAmount * Lotto.PRICE) * 10000)) / 100;
	}
}
