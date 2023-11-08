package lotto.config;

public enum LottoConfig {
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1),
    MAX_CHAR('9'),
    MIN_CHAR('0'),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1000),
    INPUT_SEPARATER(",");
    private int num;
    private char value;
    private String separater;

    LottoConfig(int num) {
        this.num = num;
    }
    LottoConfig(char value) {
        this.value = value;
    }
    LottoConfig(String separater) {
        this.separater = separater;
    }

    public int getNum() {
        return num;
    }
    public char getValue() {
        return value;
    }
    public String getSeparater() {
        return separater;
    }
}