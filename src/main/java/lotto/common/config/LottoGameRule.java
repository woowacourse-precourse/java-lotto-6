package lotto.common.config;

public enum LottoGameRule {
    LOTTO_NUMBERS_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final Integer constant;

    LottoGameRule(Integer constant) {
        this.constant = constant;
    }

    public Integer constant() {
        return constant;
    }

}
