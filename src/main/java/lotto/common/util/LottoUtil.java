package lotto.common.util;

public enum LottoUtil {
    SIZE(6),

    DUPLICATE(1);



    private final Integer number;

    LottoUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
