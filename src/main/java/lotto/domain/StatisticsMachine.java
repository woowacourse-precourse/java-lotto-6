package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.util.Rank;

public class StatisticsMachine {
	private static final int PERCENT = 100;
	private final Map<Rank, Integer> ranks;

	public StatisticsMachine(List<Rank> ranks) {
		this.ranks = new HashMap<>();
		init();
		ranks.forEach(rank -> this.ranks
			.put(rank, this.ranks
				.get(rank) + 1));
	}

	private void init() {
		Arrays.stream(Rank.values())
			.forEach(rank -> ranks.put(rank, 0));
	}

	public int countRank(Rank rank) {
		return ranks.get(rank);
	}

	public double matchPercent() {
		return totalReward() / originalPrice() * PERCENT;
	}

	private double totalReward() {
		return ranks.keySet()
			.stream()
			.mapToDouble(rank -> rank.getPrice() * countRank(rank))
			.sum();
	}

	public double originalPrice() {
		return ranks.keySet()
			.stream()
			.mapToDouble(this::countRank)
			.sum() * Lotto.PRICE;
	}
}
