package lotto.config;

public enum LottoCharRange {
    MAX_CHAR('9'),
    MIN_CHAR('0');

    private char value;
    LottoCharRange(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
