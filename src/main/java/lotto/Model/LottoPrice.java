package lotto.Model;

public class LottoPrice {
    private static final int LOTTO_PRICE = 1000;

    public int initLottoPrice(int number) {
        checkZero(number);
        return checkLottoPrice(number);
    }

    private void checkZero(int amount){
        if (amount <= 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getErrorMessage());
        }
    }

    private int checkLottoPrice(int amount){
        if (amount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_UNIT.getErrorMessage());
        }
        return amount / LOTTO_PRICE;
    }
}
