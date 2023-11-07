package lotto.service;

import java.util.HashMap;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import lotto.domain.Rank;
import lotto.domain.Result;

public class DrawService {
	public Result drawLotto(LottoWinner lottoWinner, List<Lotto> lottoList) {
		HashMap<Rank, Integer> matchCounter = new HashMap<>();
		matchCounter.put(Rank.FIRST, 0);
		matchCounter.put(Rank.SECOND, 0);
		matchCounter.put(Rank.THIRD, 0);
		matchCounter.put(Rank.FOURTH, 0);
		matchCounter.put(Rank.FIFTH, 0);

		for (Lotto lotto : lottoList) {
			int matchNormalCount = 0;
			boolean hasBonus = false;
			for (int i = 0; i < Lotto.SIZE; i++) {
				if (lottoWinner.hasNormal(lotto.get(i))) {
					matchNormalCount += 1;
				}
				if (lottoWinner.hasBonus(lotto.get(i))) {
					hasBonus = true;
				}
			}

			for (Rank rank : matchCounter.keySet()) {
				if (rank.getMatchNormalCount() == matchNormalCount && !rank.isNeedMatchBonus()) {
					matchCounter.put(rank, matchCounter.get(rank) + 1);
				}
				if (rank.getMatchNormalCount() == matchNormalCount && rank.isNeedMatchBonus() && hasBonus) {
					matchCounter.put(rank, matchCounter.get(rank) + 1);
				}
			}
		}
		return Result.of(lottoList.size(), matchCounter);
	}
}
