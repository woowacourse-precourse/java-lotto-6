package lotto.domain;

public enum Prize {
    FIRST(1, 6.0, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 5.5, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(3, 5.0, "5개 일치 (1,500,000원)"),
    FOURTH(4, 4.0, "4개 일치 (50,000원)"),
    FIFTH(5, 3.0, "3개 일치 (5,000원)");

    final private int rank;

    final private double count;
    final private String description;

    Prize(int rank, double count, String description) {
        this.rank = rank;
        this.count = count;
        this.description = description;
    }

    public int getRank() {
        return rank;
    }

    public double getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
}
