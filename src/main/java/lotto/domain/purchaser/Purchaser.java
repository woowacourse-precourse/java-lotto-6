package lotto.domain.purchaser;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

public class Purchaser {

    int purchaseAmount;

    public Purchaser(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    private void validate(String purchaseAmount) {
        validateNumber(purchaseAmount);
        validateDivisibilityByLottoPrice(purchaseAmount);
    }

    private void validateNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    private void validateDivisibilityByLottoPrice(String purchaseAmount) {
        int purchaseResult = Integer.parseInt(purchaseAmount);
        if (purchaseResult % LottoRule.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_AMOUNT.getMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
