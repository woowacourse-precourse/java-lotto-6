package lotto.config;

/**
 * 게임 관련 설정을 지정하는 enum 클래스
 */
public enum LottoConfig {
    LOTTO_MIN_VALUE(1),
    LOTTO_MAX_VALUE(45),
    MAX_INPUT_LENGTH(9),
    LOTTO_AMOUNT(1000),
    MAX_LOTTO_COUNT(10000),
    LOTTO_SIZE(6);

    private final Integer value;

    LottoConfig(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
