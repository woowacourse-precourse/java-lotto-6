package lotto.domain;

public enum LottoResult {
    FIRST(2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1500000, "5개 일치 (1,500,000원)"),
    FORTH(50000, "4개 일치 (50,000원)"),
    FIFTH(5000, "3개 일치 (5,000원)"),
    FAIL(0, "미당첨");

    private final long prize;
    private final String description;

    LottoResult(long prize, String description) {
        this.prize = prize;
        this.description = description;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
