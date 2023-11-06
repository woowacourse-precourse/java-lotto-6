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

	public String getRateOfReturn() {
		return String.format("%.2f", rateOfReturn);
	}

	private static int calculateRateOfReturn(int purchaseAmount, Map<Rank, Integer> matchCount) {
		int total = matchCount.keySet().stream()
			.mapToInt(
				rank -> matchCount.get(rank) * rank.getReward())
			.sum();
		return total / (purchaseAmount * Lotto.PRICE);
	}
}
