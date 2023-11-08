package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import lotto.domain.Rank;
import lotto.domain.Result;

public class DrawService {
	public Result drawLotto(LottoWinner lottoWinner, List<Lotto> lottoList) {
		HashMap<Rank, Integer> matchCounter = initializeRankMap();

		lottoList.stream()
			.map(lotto -> getMatchRank(lottoWinner, lotto))
			.filter(rank -> rank != Rank.MISS)
			.forEach(rank -> matchCounter.put(rank, matchCounter.get(rank) + 1));
		return Result.of(lottoList.size(), matchCounter);
	}

	private HashMap<Rank, Integer> initializeRankMap() {
		HashMap<Rank, Integer> matchCounter = new HashMap<>();
		matchCounter.put(Rank.FIRST, 0);
		matchCounter.put(Rank.SECOND, 0);
		matchCounter.put(Rank.THIRD, 0);
		matchCounter.put(Rank.FOURTH, 0);
		matchCounter.put(Rank.FIFTH, 0);
		return matchCounter;
	}

	private Rank getMatchRank(LottoWinner lottoWinner, Lotto lotto) {
		int matchNormalCount = calculateNormalCount(lottoWinner, lotto);
		boolean hasBonus = isHasBonus(lottoWinner, lotto);

		for (Rank rank : Rank.keys()) {
			if (rank.getMatchNormalCount() == matchNormalCount && !rank.isNeedMatchBonus()) {
				return rank;
			}
			if (rank.getMatchNormalCount() == matchNormalCount && hasBonus) {
				return rank;
			}
		}
		return Rank.MISS;
	}

	private static boolean isHasBonus(LottoWinner lottoWinner, Lotto lotto) {
		return IntStream.range(0, Lotto.SIZE)
			.anyMatch(i -> lottoWinner.hasBonus(lotto.get(i)));
	}

	private static int calculateNormalCount(LottoWinner lottoWinner, Lotto lotto) {
		return (int)IntStream.range(0, Lotto.SIZE)
			.filter(i -> lottoWinner.hasNormal(lotto.get(i)))
			.count();
	}
}
