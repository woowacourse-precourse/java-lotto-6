package lotto.domain.validation;

import lotto.constants.ErrorMassageConstants;

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
            throw new IllegalArgumentException(ErrorMassageConstants.CONVERT_PURCHASE_AMOUNT_ERROR_MESSAGE.getMessage(), e);
        }
    }

    private void checkAmountIsAThousandUnits(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMassageConstants.AMOUNT_IS_A_THOUSAND_UNITS_ERROR_MESSAGE.getMessage() + amount);
        }
    }

    private void checkAmountAtLeastOneLottoPrice(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(ErrorMassageConstants.AMOUNT_LEAST_ONE_LOTTO_PRICE_ERROR_MESSAGE.getMessage() + amount);
        }
    }
}
