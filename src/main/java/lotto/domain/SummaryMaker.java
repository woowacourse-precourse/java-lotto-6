package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lotto.constant.Prize;

public class SummaryMaker {

	private static final int LOTTO_PRIZE = 1000;

	private Map<String, Integer> summary;

	public void summarizeHit(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {

		make();

		for (Lotto lotto : lottos) {
			String hitResult = lotto.match(winningNumber, bonusNumber);
			summary.computeIfPresent(hitResult, (String k, Integer v) -> ++v);
		}

	}

	private void make() {

		int count = 0;

		summary = new HashMap<>();

		for (Prize prize : Prize.values()) {
			summary.put(prize.getHitResult(), count);
		}

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

	public Map<String, Integer> getSummary() {
		return this.summary;
	}
}
