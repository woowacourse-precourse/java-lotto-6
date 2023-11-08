package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, false, "3개 일치 (5,000원) - ", 5_000, 0),
    FOURTH(4, false, "4개 일치 (50,000원) - ", 50_000, 0),
    THIRD(5, false, "5개 일치 (1,500,000원) - ", 1_500_000, 0),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000, 0),
    FIRST(6, false, "6개 일치 (2,000,000,000원) - ", 2_000_000_000, 0),
    LOSE(0, false, "", 0, 0);

    private int matchCount;
    private boolean isContainBonus;
    private String message;
    private long prize;
    private int count;

    Rank(int matchCount, boolean isContainBonus, String message, int prize, int count) {
        this.matchCount = matchCount;
        this.isContainBonus = isContainBonus;
        this.message = message;
        this.prize = prize;
        this.count = count;
    }

    public static Rank getRank(int matchCount, boolean isContainBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.isContainBonus == isContainBonus)
                .findFirst()
                .orElse(LOSE);
    }

    public void increaseCount() {
        this.count++;
    }

    public long getTotalPrize() {
        return prize * count;
    }

    public int getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }
}
