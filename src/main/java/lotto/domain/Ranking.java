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

    public Ranking(Purchase purchasedLotto, WinningLotto winningLotto) {
        this.purchasedLotto = purchasedLotto;
        this.winningNumbers = winningLotto.getWinningNumbers();
        this.bonusNumber = winningLotto.getBonusNumber();
        this.rankStatus = initializeRankStatus();
    }

    private Map<Rank, Integer> initializeRankStatus() {
        Map<Rank, Integer> rankStatus = new HashMap<>();

        for (Rank rank : Rank.values()) {
            rankStatus.put(rank, 0);
        }

        return rankStatus;
    }

    public void matchLotto() {
        for (Lotto lotto : purchasedLotto.getPurchasedLotto()) {
            final int matchCount = isContainLottoNumbers(lotto);
            final int totalMatchCount = matchBonusNumber(matchCount, lotto);

            Rank matchedRank = getRankByCount(totalMatchCount);
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

    private int isContainLottoNumbers(final Lotto lotto) {
        int matchCount = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean isContainBonusNumber(final Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void updateRankCounts(final Rank matchedRank) {
        rankStatus.put(matchedRank, rankStatus.get(matchedRank) + 1);
    }

    private Rank getRankByCount(final int matchCount) {

        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount) {
                return rank;
            }
        }

        return Rank.ELSE;
    }

    public void printRankStatus() {
        System.out.println(rankStatus);
    }
}
