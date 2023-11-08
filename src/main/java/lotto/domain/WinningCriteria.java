package lotto.domain;

public enum WinningCriteria {

    FIRST_PRIZE(1, 6, false, 2_000_000_000, "2,000,000,000"),
    SECOND_PRIZE(2, 5, true, 30_000_000, "30,000,000"),
    THIRD_PRIZE(3, 5, false, 1_500_000, "1,500,000"),
    FOURTH_PRIZE(4, 4, false, 50_000, "50,000"),
    FIFTH_PRIZE(5, 3, false, 5_000, "5,000");

    private final int rank;
    private final int numberMatch;
    private final boolean bonusNumberMatch;
    private final int price;
    private final String outputPrice;

    WinningCriteria(int rank, int numberMatch, boolean bonusNumberMatch, int price, String outputPrice) {
        this.rank = rank;
        this.numberMatch = numberMatch;
        this.bonusNumberMatch = bonusNumberMatch;
        this.price = price;
        this.outputPrice = outputPrice;
    }

    public int getRank() {
        return rank;
    }

    public int getNumberMatch() {
        return numberMatch;
    }

    public boolean getBonusNumberMatch() {
        return bonusNumberMatch;
    }

    public int getPrice() {
        return price;
    }

    public String getOutputPrice() {
        return outputPrice;
    }
}
