package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.vo.LottoNumber;

import java.util.EnumMap;

public class WinningRankingCalculator {
    public EnumMap<WinningRanking, Integer> countWinningRankings(Lottos userLottos, WinningNumbers winningLotto) {
        EnumMap<WinningRanking, Integer> rankingCountMap = new EnumMap<>(WinningRanking.class);

        for (Lotto lotto : userLottos.lottos()) {
            int matchedNumberCount = countMatchedNumbers(lotto, winningLotto);
            boolean needsBonusNumber = hasBonusNumber(lotto, winningLotto);

            WinningRanking ranking = calculateRanking(matchedNumberCount, needsBonusNumber);
            rankingCountMap.put(ranking, rankingCountMap.getOrDefault(ranking, 0) + 1);
        }

        return rankingCountMap;
    }

    private int countMatchedNumbers(Lotto lotto, WinningNumbers winningLotto) {
        int matchedNumberCount = 0;
        for (LottoNumber number : winningLotto.getLotto().getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                matchedNumberCount++;
            }
        }
        return matchedNumberCount;
    }

    private boolean hasBonusNumber(Lotto lotto, WinningNumbers winningNumbers) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

    private WinningRanking calculateRanking(int matchedNumberCount, boolean needsBonusNumber) {
        if (matchedNumberCount == WinningRanking.FIRST.getMatchedNumberCount()) {
            return WinningRanking.FIRST;
        }
        if (matchedNumberCount == WinningRanking.SECOND.getMatchedNumberCount() &&
                needsBonusNumber) {
            return WinningRanking.SECOND;
        }
        if (matchedNumberCount == WinningRanking.THIRD.getMatchedNumberCount() &&
                !needsBonusNumber) {
            return WinningRanking.THIRD;
        }
        if (matchedNumberCount == WinningRanking.FOURTH.getMatchedNumberCount()) {
            return WinningRanking.FOURTH;
        }
        if (matchedNumberCount == WinningRanking.FIFTH.getMatchedNumberCount()) {
            return WinningRanking.FIFTH;
        }

        return WinningRanking.NONE;
    }
}
