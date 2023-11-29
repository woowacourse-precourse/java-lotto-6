package Constants;

import util.EnumUtil;

public enum PurchaseAmountConstant implements EnumUtil<String, Integer> {

    ONE_THOUSAND(1000),
    ZERO(0);

    private final int number;

    PurchaseAmountConstant(final int number){
        this.number = number;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return number;
    }
}
