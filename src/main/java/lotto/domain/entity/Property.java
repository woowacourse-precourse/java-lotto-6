package lotto.domain.entity;

import lotto.domain.config.PropertyConfig;
import lotto.domain.util.validator.PropertyValidator;

public class Property {
    private static final double PERCENT_CONVERSION_FACTOR = 100.0;
    private static final int PRICE_PER_LOTTO = PropertyConfig.PRICE_PER_LOTTO.getValue();

    private final int property;

    public Property(int property) {
        PropertyValidator.validate(property);
        this.property = property;
    }

    public int getNumberOfLotto() {
        return property / PRICE_PER_LOTTO;
    }

    public double getRateOfReturn(int revenue) {
        return ((double) revenue - property) / property * PERCENT_CONVERSION_FACTOR;
    }
}
