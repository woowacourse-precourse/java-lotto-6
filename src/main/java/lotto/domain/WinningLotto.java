package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
	private WinningNumbers winningNumbers;
	private Bonus bonus;
	private Map<Prize, Integer> results = new HashMap<>();

	public WinningLotto(WinningNumbers winningNumbers, Bonus bonus) {
		this.winningNumbers = winningNumbers;
		this.bonus = bonus;
	}

	public Map calculateWinningLotto(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
				int matchNumber = winningNumbers.compareWith(lotto);
				boolean isBonus = canMatchBonus(lotto);
				Prize prize = Prize.createResult(matchNumber, isBonus);

				results.put(prize, results.getOrDefault(prize, 0) + 1);
		}
		return results;
	}

	public boolean canMatchBonus(Lotto lotto) {
		return winningNumbers.compareWith(lotto) == 5 && bonus.compareWith(lotto);
	}

}
