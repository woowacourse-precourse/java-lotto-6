package lotto.domain;

import java.util.Arrays;

public enum Rank {

    BOOM(0, false, "꽝", "(0원)"),
    FIFTH(3, false, "3개 일치", "(5,000원)"),
    FOURTH(4, false, "4개 일치", "(50,000원)"),
    THIRD(5, false, "5개 일치", "(1,500,000원)"),
    SECOND(5, true, "5개 일치", "보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, "6개 일치", "(2,000,000,000원)");

    private int sameCount;
    private boolean sameBonus;
    private String sameCountMessage;
    private String price;

    Rank(int sameCount, boolean sameBonus, String sameCountMessage, String price) {
        this.sameCount = sameCount;
        this.sameBonus = sameBonus;
        this.sameCountMessage = sameCountMessage;
        this.price = price;
    }

    public Rank getRank(int sameCount, boolean sameBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameRank(rank, sameCount, sameBonus))
                .findAny()
                .orElse(Rank.BOOM);
    }

    private boolean isSameRank(final Rank rank, final int sameCount, final boolean sameBonus) {
        return rank.sameCount == sameCount && rank.sameBonus == sameBonus;
    }
}
