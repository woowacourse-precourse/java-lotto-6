package lotto.service;

import lotto.LottoConstants;
import lotto.StringConstants;

public class LottoPurchaseService {

    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        int amount = validateLottoPurchaseAmount(purchaseAmount);
        return amount / LottoConstants.PRICE.getValue();
    }

    public int validateLottoPurchaseAmount(String lottoPurchaseAmount) {
        int amount = validateIsDigit(lottoPurchaseAmount);
        validateIsDivisibleBy1000(amount);
        return amount;
    }

    private void validateIsDivisibleBy1000(int amount) {
        if (amount % LottoConstants.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(
                    StringConstants.FIRST_ERROR_MESSAGE + StringConstants.PURCHASE_AMOUNT_DIVIDE_EXCEPTION_MESSAGE);
        }
    }

    private int validateIsDigit(String lottoPurchaseAmount) {
        try {
            return Integer.parseInt(lottoPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    StringConstants.FIRST_ERROR_MESSAGE + StringConstants.PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }
}