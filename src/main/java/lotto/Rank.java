package lotto;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    MISS(0, 0, "");

    final private int count;
    final private int amount;
    final private String phrase;

    Rank(int count, int amount, String phrase) {
        this.count = count;
        this.amount = amount;
        this.phrase = phrase;
    }

    int getCount() {
        return count;
    }

    int getAmount() {
        return amount;
    }

    String getPhrase() {
        return phrase;
    }
}
