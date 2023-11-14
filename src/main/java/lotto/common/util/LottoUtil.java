package lotto.common.util;

public enum LottoUtil {
    SIZE(6),
    DUPLICATE(1),
    MIN(1),
    MAX(45),
    THOUSAND(1000),
    HUNDRED(100),
    ZERO(0),
    RANK_ONE(6),
    RANK_TWO(5),
    RANK_THREE(5),
    RANK_FOUR(4),
    RANK_FIVE(3),
    RANK_ONE_PRICE(2000000000),
    RANK_TWO_PRICE(30000000),
    RANK_THREE_PRICE(1500000),
    RANK_FOUR_PRICE(50000),
    RANK_FIVE_PRICE(5000);

    private final Integer number;

    LottoUtil(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
