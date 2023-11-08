package lotto;

public class Util {
    private final static int LOTTO_UNIT_PRICE = 1000;
    int countPurchasedLotto(int totalPrice){
        int count = totalPrice/LOTTO_UNIT_PRICE;
        return count;
    }
}
