package lotto.domain.entity;

import lotto.domain.config.PropertyConfig;
import lotto.domain.util.validator.PropertyValidator;
import lotto.domain.valueobject.Statistics;

public class Order {
    private static final int PRICE_PER_LOTTO = PropertyConfig.PRICE_PER_LOTTO.getValue();
    private static final double PERCENT_CONVERSION_FACTOR = 100.0;

    private final int property;
    private Statistics statistics;

    public Order(int property) {
        PropertyValidator.validate(property);
        this.property = property;
        statistics = new Statistics();
    }

    public int getNumberOfPurchaseLotto() {
        return property / PRICE_PER_LOTTO;
    }

    public int getProperty() {
        return property;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public double getRateOfReturn() {
        return ((double) statistics.getRevenue()) / property * PERCENT_CONVERSION_FACTOR;
    }
}
