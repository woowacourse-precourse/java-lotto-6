package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum LottoRank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int correctCount;
    private final int prize;
    private final boolean isCorrectBonus;

    LottoRank(int correctCount, int prize, boolean isCorrectBonus) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.isCorrectBonus = isCorrectBonus;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isCorrectBonus() {
        return isCorrectBonus;
    }

    public static LottoRank getRank(Lotto lotto, WinningLotto winningLotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto.getNumbers());
        Set<Integer> winningLottoSet = new HashSet<>(winningLotto.getLotto().getNumbers());

        int duplicatedCount = (int) winningLottoSet.stream().filter(lottoSet::contains).count();
        boolean isBonusCorrect = lottoSet.contains(winningLotto.getBonusNumber());

        return findByNormalAndBonus(duplicatedCount, isBonusCorrect);
    }

    private static LottoRank findByNormalAndBonus(int normalCount, boolean isCorrectBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.correctCount == normalCount
                        && lottoRank.isCorrectBonus == isCorrectBonus)
                .findFirst()
                .orElse(null);
    }
}
