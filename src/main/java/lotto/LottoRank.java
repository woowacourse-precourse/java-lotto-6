package lotto;

import java.util.HashSet;
import java.util.Set;

public enum LottoRank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int correctCount;
    private final int prize;
    private final boolean isCorrectBonus;

    LottoRank(int correctCount, int prize, boolean isCorrectBonus) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.isCorrectBonus = isCorrectBonus;
    }

    public static LottoRank getRank(Lotto lotto, WinningLotto winningLotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto.getNumbers());
        Set<Integer> winningLottoSet = new HashSet<>(winningLotto.getLotto().getNumbers());
        winningLottoSet.retainAll(lottoSet);

        return findByNormalAndBonus(winningLottoSet.size(), lottoSet.contains(winningLotto.getBonusNumber()));
    }

    private static LottoRank findByNormalAndBonus(int normalCount, boolean isCorrectBonus) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.correctCount == normalCount && lottoRank.isCorrectBonus == isCorrectBonus) {
                return lottoRank;
            }
        }
        return null;
    }
}
