package lotto.domain.constant;

public enum Range {
    LOTTO_SIZE(6),
    LOTTO_NUMBER_LOWER_LIMIT(1),
    LOTTO_NUMBER_UPPER_LIMIT(45),
    PURCHASE_COST_LOWER_LIMIT(1000),
    PURCHASE_COST_UPPER_LIMIT(1_000_000),
    PURCHASE_COST_UNIT(1000);

    public final Integer limit;

    Range(Integer limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
