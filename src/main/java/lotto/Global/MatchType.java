package lotto.Global;

public enum MatchType {
    TRUE(1),
    FALSE(0),
    NO(-1);

    private int number;

    private MatchType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
