package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
	private final WinningNumbers winningNumbers;
	private final Bonus bonus;
	private Map<Prize, Integer> results = new HashMap<>();

	public WinningLotto(WinningNumbers winningNumbers, Bonus bonus) {
		this.winningNumbers = winningNumbers;
		this.bonus = bonus;
	}

	public Map calculateResult(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
				int matchAmount = winningNumbers.compareWith(lotto);
				boolean matchBonus = canMatchBonus(lotto);
				Prize prize = Prize.createResult(matchAmount, matchBonus);

				results.put(prize, results.getOrDefault(prize, 0) + 1);
		}
		return results;
	}

	public boolean canMatchBonus(Lotto lotto) {
		return winningNumbers.compareWith(lotto) == 5 && bonus.compareWith(lotto.getLotto());
	}
}
