package util.constants;

import util.EnumUtil;

public enum Constants implements EnumUtil<String, Integer> {
    ONE_THOUSAND(1000),
    ZERO(0),
    WINNING_MIN_COUNT(3);

    private final int number;

    Constants(final int number){
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
