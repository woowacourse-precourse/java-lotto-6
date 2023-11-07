package lotto.model;

import lotto.utils.ErrorMessage;

import static java.lang.Integer.parseInt;

public class LottoPurchasingAmount {
    private static final int LOTTO_MINIMUM_PRICE = 1000;
    private final int lottoAmount;

    public LottoPurchasingAmount(String moneyFromUserInput) {
        int moneyFromUser = validateNumber(moneyFromUserInput);
        this.lottoAmount = moneyFromUser / LOTTO_MINIMUM_PRICE;
    }

    private int validateNumber(String money) {
        try {
            return parseInt(money);
        } catch (NumberFormatException e) {
            ErrorMessage.numberException();
            throw new IllegalArgumentException();
        }
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
