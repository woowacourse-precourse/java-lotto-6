package lotto.Enum;

public enum Rank {
    FIFTH("3개 일치 (5,000원)", 5000, 3),
    FOURTH("4개 일치 (50,000원)", 50000, 4),
    THIRD("5개 일치 (1,500,000원)", 1500000, 5),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 7),
    FIRST("6개 일치 (2,000,000,000원)", 2000000000, 6);

    private final String description;
    private final int prizeAmount;
    private final int correctNumbers;

    Rank(String description, int prizeAmount, int correctNumbers) {
        this.description = description;
        this.prizeAmount = prizeAmount;
        this.correctNumbers = correctNumbers;
    }

    public String getDescription() {
        return description;
    }
    public int getPrizeAmount() {
        return prizeAmount;
    }
    public int getCorrectNumbers() {
        return correctNumbers;
    }
}
