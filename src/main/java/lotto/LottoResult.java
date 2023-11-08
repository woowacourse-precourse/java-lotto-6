package lotto;

public enum LottoResult {
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000, 6),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 5),
    THIRD("5개 일치 (1,500,000원)", 1_500_000, 5),
    FOURTH("4개 일치 (50,000원)", 50_000, 4),
    FIFTH("3개 일치 (5,000원)", 5_000, 3);

    private final String detail;
    private final int prize;
    private final int match;

    LottoResult(String detail, int prize, int match) {
        this.detail = detail;
        this.prize = prize;
        this.match = match;
    }

    public String getDetail() {
        return detail;
    }

    public int getMatch() {
        return match;
    }
    public int multiplePrize(int amount) {
        return prize * amount;
    }
}
