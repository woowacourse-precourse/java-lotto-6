package lotto.domain;

public enum LottoRank {
    /*
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
    */
    FIRST(200000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(30000000, 3, false),
    NONE(0, 0, false);
    private final int amount;
    private final int count;
    private final boolean hasBonus;

    LottoRank(int amount, int count, boolean hasBonus) {
        this.amount = amount;
        this.count = count;
        this.hasBonus = hasBonus;
    }

}
