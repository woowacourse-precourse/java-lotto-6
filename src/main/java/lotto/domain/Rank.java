package lotto.domain;

public enum Rank {
    FIFTH(0, "3개 일치 (5,000원)"),
    FOURTH(1, "4개 일치 (50,000원)"),
    THIRD(2, "5개 일치 (1,500,000원)"),
    SECOND(3, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(4, "6개 일치 (2,000,000,000원)");

    private final int index;
    private final String description;

    Rank(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}