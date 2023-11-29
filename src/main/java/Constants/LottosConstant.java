package Constants;

import util.EnumUtil;

public enum LottosConstant implements EnumUtil<String, Integer> {
    MIN_VALUE(1),
    MAX_VALUE(45),
    LOTTO_SIZE(6);

    private final int number;

    LottosConstant(final int number){
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
