package lotto.model;

import static lotto.errorMessage.ExceptionErrorMessage.INPUT_ONLY_NUMBER;
import static lotto.errorMessage.ExceptionErrorMessage.PURCHASE_LOTTO_PRICE;

public class PlayerPurchase {
    private static final int Lotto_Price = 1000;
    private final int inputPrice;

    public PlayerPurchase(String amount) {
        int lotto_Price = convertToInt(amount);
        validateLottoPrice(lotto_Price);
        this.inputPrice = lotto_Price;
    }


    public int calculateLottoCount() {
        return inputPrice / Lotto_Price;
    }

    private static int convertToInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER);
        }

    }

    private void validateLottoPrice(int amount) {
        if (amount % Lotto_Price != 0 || amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_LOTTO_PRICE);
        }
    }
}
