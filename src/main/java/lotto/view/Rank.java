package lotto.view;

public enum Rank {
    FIFTH_PLACE(3, "3개 일치 (5,000원)"),
    FOURTH_PLACE(4, "4개 일치 (50,000원)"),
    THIRD_PLACE(5, "5개 일치 (1,500,000원)"),
    SECOND_PLACE(6, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PLACE(-1, "6개 일치 (2,000,000,000원)");

    private final int matchedAmount;
    private final String mean;

    Rank(int matchedAmount, String mean) {
        this.matchedAmount = matchedAmount;
        this.mean = mean;
    }

    public String getMean() {
        return mean;
    }
}
