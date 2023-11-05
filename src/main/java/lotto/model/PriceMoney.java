package lotto.model;

import java.util.Arrays;

public enum PriceMoney {

    NOTHING(0, 0),
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final Integer count;
    private final Integer price;

    PriceMoney(Integer count, Integer price) {
        this.count = count;
        this.price = price;
    }

    public static Integer getPrice(PriceMoney priceMoney) {
        return priceMoney.price;
    }

    public static PriceMoney getRank(Integer count, boolean hasbonusNumber) {
        if (count.equals(5) && hasbonusNumber == true) {
            return SECOND;
        }
        return Arrays.stream(PriceMoney.values())
                .filter(rank -> rank.count.equals(count))
                .findAny()
                .orElse(NOTHING);
    }
}
