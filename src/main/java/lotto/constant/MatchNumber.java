package lotto.constant;

public enum MatchNumber {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int number;

    MatchNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
