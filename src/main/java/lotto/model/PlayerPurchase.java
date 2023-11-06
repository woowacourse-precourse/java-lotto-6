package lotto.model;

import static lotto.errorMessage.ExceptionErrorMessage.PURCHASE_LOTTO_PRICE;

public class PlayerPurchase {
    private static final int Lotto_Price = 1000;
    private final int inputPrice; // 내가 입력한 금액

    public PlayerPurchase(String amount) { // 내가 입력했을 때 8000은 문자열
        int lotto_Price = convertToInt(amount);
        validateLottoPrice(lotto_Price);
        this.inputPrice = lotto_Price;
    }


    // 구입 금액에서 1000을 나눔.
    public int calculateLottoCount() {
        return inputPrice / Lotto_Price;
    }

    private static int convertToInt(String amount) {
        return Integer.parseInt(amount);
    }


    private void validateLottoPrice(int amount) {
        if (amount % Lotto_Price != 0 || amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_LOTTO_PRICE);
        }
    }
}
