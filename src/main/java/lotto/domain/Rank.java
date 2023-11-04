package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {
    _1ST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원) - "),
    _2ND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    _3RD(5, false, 1_500_000L, "5개 일치 (1,500,000원) - "),
    _4TH(4, false, 50_000L, "4개 일치 (50,000원) - "),
    _5TH(3, false, 5_000L, "3개 일치 (5,000원) - "),
    BLANK(0, false, 0L, "");

    private final int correctCount;
    private final boolean isBonus;
    private final long prizeMoney;
    private final String showPrizeMoney;

    Rank(int correctCount, boolean isBonus, long prizeMoney, String showPrizeMoney) {
        this.correctCount = correctCount;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
        this.showPrizeMoney = showPrizeMoney;
    }

    public static Rank findByRank(int correctCount, boolean isBonus) {
        Stream<Rank> ranks = Arrays.stream(Rank.values());

        if (correctCount == Rank._2ND.correctCount) {
            return ranks.filter(rank -> rank.hasCorrectCount(correctCount)
                            && rank.isCorrectBonus(isBonus))
                    .findAny()
                    .orElse(BLANK);
        }

        return ranks.filter(rank -> rank.hasCorrectCount(correctCount))
                .findAny()
                .orElse(BLANK);
    }

    private boolean isCorrectBonus(boolean isBonus) {
        return this.isBonus == isBonus;
    }

    private boolean hasCorrectCount(int correctCount) {
        return this.correctCount == correctCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getShowPrizeMoney() {
        return showPrizeMoney;
    }
}
