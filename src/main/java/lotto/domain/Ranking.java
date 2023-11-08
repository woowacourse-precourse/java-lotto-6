package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lotto.WinningLotto;
import lotto.constant.Rank;

public class Ranking {
    private final Purchase purchasedLotto;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Rank, Integer> rankStatus;

    public Ranking(final Purchase purchasedLotto, final WinningLotto winningLotto) {
        this.purchasedLotto = purchasedLotto;
        this.winningNumbers = winningLotto.getWinningNumbers();
        this.bonusNumber = winningLotto.getBonusNumber();
        this.rankStatus = initializeRankStatus();
        rankingLotto();
    }

    private Map<Rank, Integer> initializeRankStatus() {
        Map<Rank, Integer> rankStatus = new HashMap<>();

        for (final Rank rank : Rank.values()) {
            rankStatus.put(rank, 0);
        }

        return rankStatus;
    }

    private void rankingLotto() {
        for (final Lotto lotto : purchasedLotto.getPurchasedLotto()) {
            final int matchCount = matchedLottoNumberCount(lotto);
            final int totalMatchCount = matchBonusNumber(matchCount, lotto);
            final Rank matchedRank = getRankByCount(totalMatchCount);

            updateRankCounts(matchedRank);
        }
    }

    private int matchBonusNumber(final int matchCount, final Lotto lotto) {
        int totalMatchCount = matchCount;

        if (totalMatchCount == 5 && isContainBonusNumber(lotto)) {
            totalMatchCount += 2;
        }

        return totalMatchCount;
    }

    private int matchedLottoNumberCount(final Lotto lotto) {
        int matchCount = 0;

        for (final int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean isContainBonusNumber(final Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void updateRankCounts(final Rank rank) {
        rankStatus.put(rank, rankStatus.get(rank) + 1);
    }

    private Rank getRankByCount(final int matchCount) {
        for (final Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount) {
                return rank;
            }
        }

        return Rank.ELSE;
    }

    public final Map<Rank, Integer> getRankStatus() {
        return rankStatus;
    }
}
