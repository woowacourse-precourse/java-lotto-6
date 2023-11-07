package lotto.exception;

public class PriceCheck {
    private static final int standardPrice = 1000;
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
