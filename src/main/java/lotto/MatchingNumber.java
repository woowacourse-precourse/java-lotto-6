package lotto;

public enum MatchingNumber {
    Three(3),
    Four(4),
    Five(5),
    FiveBonus(6),
    Six(7);

    private final int value;

    MatchingNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
