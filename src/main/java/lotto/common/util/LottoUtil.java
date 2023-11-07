package lotto.common.util;

public enum LottoUtil {
    SIZE(6),
    DUPLICATE(1),
    MIN(1),
    MAX(45),
    THOUSAND(1000),
    ZERO(0);


    private final Integer number;

    LottoUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
