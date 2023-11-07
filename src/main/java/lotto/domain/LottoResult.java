package lotto.domain;

import static lotto.domain.WinningRank.*;

public class LottoResult {

	private final int matchCount;
	private final boolean matchBonusNumber;
	private final WinningRank winningRank;

	public LottoResult(int matchCount, boolean matchBonusNumber) {
		this.matchCount = matchCount;
		this.matchBonusNumber = matchBonusNumber;
		this.winningRank = rank(matchCount, matchBonusNumber);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public boolean isMatchBonusNumber() {
		return matchBonusNumber;
	}

	public WinningRank getWinningRank() {
		return winningRank;
	}

	private WinningRank rank(int matchCount, boolean matchBonusNumber) {
		if (matchCount == 3)
			return WinningRank.FIFTH;
		if (matchCount == 4)
			return WinningRank.FOURTH;
		if (matchCount == 5 && !matchBonusNumber)
			return WinningRank.THIRD;
		if (matchCount == 5 && matchBonusNumber)
			return WinningRank.SECOND;
		if (matchCount == 6)
			return WinningRank.FIRST;

		return WinningRank.FAIL;
	}
}
