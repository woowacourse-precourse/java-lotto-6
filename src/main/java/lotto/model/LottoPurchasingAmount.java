package lotto.model;

import lotto.utils.ErrorMessage;

import static java.lang.Integer.parseInt;

public class LottoPurchasingAmount {
    private static final int LOTTO_MINIMUM_PRICE = 1000;
    private final int lottoAmount;

    public LottoPurchasingAmount(String moneyFromUserInput) {
        int moneyFromUser = validateNumber(moneyFromUserInput);
        validateMinimumPrice(moneyFromUser);
        validateDivisible(moneyFromUser);
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

    private void validateMinimumPrice(int money) {
        if (money < LOTTO_MINIMUM_PRICE) {
            ErrorMessage.minimumLottoPriceException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int money) {
        if (money % LOTTO_MINIMUM_PRICE != 0) {
            ErrorMessage.indivisibleLottoPriceException();
            throw new IllegalArgumentException();
        }
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
