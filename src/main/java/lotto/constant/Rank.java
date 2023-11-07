package lotto.constant;

public enum Rank {
    FIRSTRANK("FIRST"),
    SECONDRANK("SECOND"),
    THIRDRANK("THIRD"),
    FOURTHRANK("FOURTH"),
    FIFTHRANK("FIFTH"),
    NOMATCHING("NOMATCHING");
    private final String value;

    Rank(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
