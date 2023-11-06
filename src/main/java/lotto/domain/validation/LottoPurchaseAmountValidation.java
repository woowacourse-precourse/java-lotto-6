package lotto.domain.validation;

import static java.lang.Integer.parseInt;

public class LottoPurchaseAmountValidation {
    private String lottoPurchaseAmount;
    private static int lottoAmount;

    public LottoPurchaseAmountValidation(String lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public int purchaseAmountValidation() {
        lottoAmount = parseLottoPurchaseAmount(lottoPurchaseAmount);
        checkAmountIsAThousandUnits(lottoAmount);
        checkAmountAtLeastOneLottoPrice(lottoAmount);
        return lottoAmount;
    }

    private int parseLottoPurchaseAmount(String amountStr) {
        try {
            return parseInt(amountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : The provided lotto purchase amount is not a valid integer: " + amountStr, e);
        }
    }

    private void checkAmountIsAThousandUnits(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : The provided amount is not a multiple of 1000: " + amount);
        }
    }

    private void checkAmountAtLeastOneLottoPrice(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] : The provided amount is less than the minimum lotto purchase amount: " + amount);
        }
    }
}
