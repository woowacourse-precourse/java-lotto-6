package lotto.enums;

public enum Lotto {
    LOTTO_3(3, 5000, "3개 일치 (5,000원) - %d개"),
    LOTTO_4(4, 50000, "4개 일치 (50,000원) - %d개"),
    LOTTO_5(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    LOTTO_5_PLUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    LOTTO_6(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    ;


    private final int matchCount;
    private final int prizeMoney;
    private final String message;

    Lotto(int matchCount, int prizeMoney, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
