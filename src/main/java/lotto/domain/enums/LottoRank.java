package lotto.domain.enums;

public enum LottoRank {
    FIFTH(5000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final int matchCount;
    private final boolean matchBonus;
    private final String message;

    LottoRank(int prize, int matchCount, boolean matchBonus, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.message = message;
    }
}
