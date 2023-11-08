package lotto.model;

public enum LottoMatchResult {

    MATCHED(1),
    NOT_MATCHED(0);

    private final int value;

    LottoMatchResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
