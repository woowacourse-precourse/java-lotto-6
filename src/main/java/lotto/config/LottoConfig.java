package lotto.config;

public enum LottoConfig {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_COUNT(6),
    LOTTO_FIRST_NUMBER(1),
    LOTTO_SECOND_NUMBER(2),
    LOTTO_THIRD_NUMBER(3),
    LOTTO_FOURTH_NUMBER(4),
    LOTTO_FIFTH_NUMBER(5),
    LOTTO_SIXTH_NUMBER(6),
    LOTTO_NUMBER_SPLIT_COMMA(",");

    private int value;
    private String content;

    LottoConfig(int value) {
        this.value = value;
    }

    LottoConfig(String content) {
        this.content = content;
    }

    public int getValue() {
        return value;
    }

    public String getContent() {
        return content;
    }

}
