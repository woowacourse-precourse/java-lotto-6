package lotto.constant;

import java.text.NumberFormat;
import java.util.Locale;

public enum LottoPrice {
    FIRST(6, 2000000000),
    SECOND(15, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int number;
    private final int price;

    LottoPrice(int number, int price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public String FormatPrice() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        return numberFormat.format(price);
    }
}
