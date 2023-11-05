package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.config.LottoRank;

public class LottoResult {

	private final WinningLotto winningLotto;
	private final LottoPlayer lottoPlayer;
	private final Map<LottoRank, Integer> rankResult = new HashMap<>();

	public LottoResult(WinningLotto winningLotto, LottoPlayer lottoPlayer) {
		this.winningLotto = winningLotto;
		this.lottoPlayer = lottoPlayer;

		calculateRanks();
	}

	public Map<LottoRank, Integer> getRankResult() {
		return rankResult;
	}

	private void calculateRanks() {
		for (Lotto lotto : lottoPlayer.getPurchasedLottos()) {
			int matchCount = winningLotto.calculateMatchCount(lotto);
			boolean matchBonusNumber = winningLotto.isBonusMatch(lotto);

			LottoRank rank = LottoRank.findRank(matchCount, matchBonusNumber);
			rankResult.put(rank, rankResult.getOrDefault(rank, 0) + 1);
		}
	}

	public double calculateReturnRate() {
		long totalPrize = 0;

		for (LottoRank rank : LottoRank.values()) {
			totalPrize += rank.getWinningMoney() * rankResult.getOrDefault(rank, 0);
		}

		return lottoPlayer.getPurchaseAmount().calculateReturnRate(totalPrize);
	}
}