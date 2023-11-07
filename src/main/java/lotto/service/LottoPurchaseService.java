package lotto.service;

import lotto.LottoConstants;
import lotto.StringConstants;

public class LottoPurchaseService {
    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        validateLottoPurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount) / LottoConstants.PRICE.getValue();
    }

    public void validateLottoPurchaseAmount(String lottoPurchaseAmount) {

        if (purchaseAmountNotDivideBy1000(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                StringConstants.FIRST_ERROR_MESSAGE + StringConstants.PURCHASE_AMOUNT_DIVIDE_EXCEPTION_MESSAGE);
        }

        if (purchaseAmountNotDigit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                StringConstants.FIRST_ERROR_MESSAGE + StringConstants.PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean purchaseAmountNotDivideBy1000(String lottoPurchaseAmount) {
        int amount = Integer.parseInt(lottoPurchaseAmount);
        return amount % LottoConstants.PRICE.getValue() != 0;
    }

    private boolean purchaseAmountNotDigit(String lottoPurchaseAmount) {
        try {
            Integer.parseInt(lottoPurchaseAmount);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}