package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lotto.constant.Prize;

public class SummaryMaker {

	private static final int LOTTO_PRIZE = 1000;

	private final Map<String, Integer> summary;

	public SummaryMaker() {

		int count = 0;
		summary = new HashMap<>();

		for (Prize prize : Prize.values()) {
			summary.put(prize.getHitResult(), count);
		}

	}


	public Map<String, Integer> summarizeHit(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {

		for (Lotto lotto : lottos) {
			String hitResult = lotto.match(winningNumber, bonusNumber);
			summary.computeIfPresent(hitResult, (String k, Integer v) -> ++v);
		}

		return summary;
	}


	public double calculateYield(int purchaseTime) {

		int purchaseAmount = purchaseTime * LOTTO_PRIZE;

		long winPirze = 0;

		for (Prize prize : Prize.values()) {
			int count = summary.get(prize.getHitResult());
			winPirze += prize.getMoney() * count;
		}

		return winPirze / (double)purchaseAmount;
	}

}
