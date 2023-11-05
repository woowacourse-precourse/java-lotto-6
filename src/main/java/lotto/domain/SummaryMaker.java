package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lotto.Prize;

public class SummaryMaker {

	private Map<String, Integer> summary;

	public Map<String, Integer> summarizeHit(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {

		make();

		for (Lotto lotto : lottos) {
			String hitResult = lotto.match(winningNumber, bonusNumber);
			summary.computeIfPresent(hitResult, (String k, Integer v) -> ++v);
		}

		return summary;
	}

	private void make() {

		int count = 0;

		summary = new HashMap<>();

		for (Prize prize : Prize.values()) {
			summary.put(prize.getHitResult(), count);
		}

	}

}
