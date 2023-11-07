package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    MISS(0, 0, ""); // 꽝

    private final int matchCount;
    private final int prize;
    private final String description;

    WinningRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int calculatePrize(int count) {
        if (matchCount == 5) {
            if (count == 5) {
                return prize;
            } else if (count == 6) {
                return 0; // 보너스 번호는 2등에 해당하므로, 6개 일치 시 당첨금 없음
            }
        }
        return prize * count;
    }
}