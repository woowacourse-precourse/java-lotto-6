package lotto.domain;

import java.util.Arrays;

public enum WinnerRank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치");

    private int match;
    private boolean hasBonusNumber;
    private int prize;
    private String display;

    WinnerRank(int match, boolean hasBonusNumber, int prize, String display) {
        this.match = match;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
        this.display = display;
    }

    public static WinnerRank getRank(int match, boolean hasBonusNumber) {
        return Arrays.stream(WinnerRank.values())
                .filter(rank -> rank.match == match)
                .filter(rank -> rank.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(null);
    }

    public int getPrize() {
        return prize;
    }

    public String getDisplay() {
        return display;
    }
}
