package lotto.domain;

public enum Prize {
    FIRST(6.0,"6개 일치 (2,000,000,000원)"),
    SECOND(5.5,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5.0,"5개 일치 (1,500,000원)"),
    FOURTH(4.0,"4개 일치 (50,000원)"),
    FIFTH(3.0,"3개 일치 (5,000원)");

    final private double count;

    final private String description;
    Prize(double count, String description) {
        this.count = count;
        this.description = description;
    }

    public double getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
}
