package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.EnumMap;

public class GameResult {
    private EnumMap<Rank, Integer> result;

    public GameResult() {
        result = initGameResult();
    }

    public EnumMap<Rank, Integer> initGameResult() {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
        return ranks;
    }

    public void calculateWinningResult(final WinningNumbers winningNumbers, final Lotto lotto) {
        int correctCount = winningNumbers.matchCount(lotto);
        boolean hasBonusNumber = lotto.hasElement(winningNumbers.getBonusNumber());
        Rank rank = Rank.determineRank(correctCount, hasBonusNumber);
        result.put(rank, result.get(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return result.get(rank);
    }
}
