package lotto.domain;

import java.util.Arrays;

public enum Rank {
    _1ST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원) - "),
    _2ND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    _3RD(5, false, 1_500_000L, "5개 일치 (1,500,000원) - "),
    _4TH(4, false, 50_000L, "4개 일치 (50,000원) - "),
    _5TH(3, false, 5_000L, "3개 일치 (5,000원) - "),
    BLANK(0, false, 0L, "");

    private final int correctCount;
    private final boolean isBonusNumber;
    private final long prizeMoney;
    private final String showPrizeMoney;

    Rank(int correctCount, boolean isBonusNumber, long prizeMoney, String showPrizeMoney) {
        this.correctCount = correctCount;
        this.isBonusNumber = isBonusNumber;
        this.prizeMoney = prizeMoney;
        this.showPrizeMoney = showPrizeMoney;
    }

    public static Rank findByRank(int correctCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.hasCorrectCount(correctCount))
                .findAny()
                .orElse(BLANK);
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
