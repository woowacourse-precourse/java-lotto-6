package lotto.Domain.LottoResult;

public enum Rank {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    MISS(0);

    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
