package lotto.util;

import lotto.model.Price;

public class PriceException {

    private static final int standardPrice = 1000;

    public static Price priceException(int price) throws IllegalArgumentException{
        zeroPriceException(price);
        thousandPriceException(price);
        return new Price(price);
    }

    public static void zeroPriceException(int price) throws IllegalArgumentException{
        if (!checkZeroPrice(price)) {
            throw new IllegalArgumentException("[ERROR] : 천원 이상부터 구입가능합니다.");
        }
    }

    public static void thousandPriceException(int price) throws IllegalArgumentException {
        if (!checkThousandPrice(price)) {
            throw new IllegalArgumentException("[ERROR] : 천원의 단위입니다. 다시 구입하세요.");
        }
    }

    public static boolean checkZeroPrice(int price){
        if (price < standardPrice) {
            return false;
        }
        return true;
    }

    public static boolean checkThousandPrice(int price) {
        if (price % standardPrice != 0) {
            return false;
        }
        return true;
    }
}
