package lotto.util;

public enum LottoDetails {
    COUNT_OF_LOTTO_NUMBER(6),

    MINIMUM_OF_LOTTO_NUMBER(1),
    MAXIMUM_OF_LOTTO_NUMBER(45);

    private final Integer details;

    LottoDetails(Integer details) {
        this.details = details;
    }

    public Integer getDetails() {
        return details;
    }
}
