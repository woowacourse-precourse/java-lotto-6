package lotto.config;

/**
 * 게임 관련 설정을 지정하는 enum 클래스
 */
public enum LottoConfig {
    MAX_INPUT_LENGTH(9),
    LOTTO_AMOUNT(1000),
    MAX_LOTTO_COUNT(10000);

    private final Integer value;

    LottoConfig(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
