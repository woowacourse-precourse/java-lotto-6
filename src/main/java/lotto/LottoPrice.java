package lotto;

import java.util.List;

public class LottoPrice {
    private final int Price;

    public LottoPrice(int Price) {
        validate(Price);
        this.Price = Price;
    }

    public int makeReturnNum() {
        return Price/1000;
    }

    private void validate(int Price) {
        if (Price==0) {
            throw new IllegalArgumentException();
        }
    }
}
