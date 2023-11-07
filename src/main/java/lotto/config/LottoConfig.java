package lotto.config;

public enum LottoConfig {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1000),
    LOTTO_NO_REMAIN(0),
    LOTTO_FIRST_NUMBER(1),
    LOTTO_SECOND_NUMBER(2),
    LOTTO_THIRD_NUMBER(3),
    LOTTO_FOURTH_NUMBER(4),
    LOTTO_FIFTH_NUMBER(5),
    LOTTO_SIXTH_NUMBER(6),
    LOTTO_NUMBER_SPLIT_COMMA(","),
    LOTTO_THREE_MATCH(3),
    LOTTO_FOUR_MATCH(4),
    LOTTO_FIVE_OR_BONUS_MATCH(5),
    LOTTO_ALL_MATCH(6),
    LOTTO_THREE_MATCH_PRIZE(5000),
    LOTTO_FOUR_MATCH_PRIZE(50000),
    LOTTO_FIVE_MATCH_PRIZE(1500000),
    LOTTO_BONUS_MATCH_PRIZE(30000000),
    LOTTO_ALL_MATCH_PRIZE(2000000000),;

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
