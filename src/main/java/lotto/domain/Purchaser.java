package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

public class Purchaser {
    int purchaseAmount;

    public Purchaser(String purchaseAmount) {
        this.purchaseAmount = validate(purchaseAmount);
    }

    private int validate(String purchaseAmount) {
        validateNumber(purchaseAmount);
        return validateDivisibilityByLottoPrice(purchaseAmount);
    }

    private void validateNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    private int validateDivisibilityByLottoPrice(String purchaseAmount) {
        int purchaseResult = Integer.parseInt(purchaseAmount);
        if(purchaseResult % LottoRule.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_AMOUNT.getMessage());
        }
        return purchaseResult / LottoRule.LOTTO_PRICE.getNumber();
    }

    public int getNumberOfLottos() {
        return purchaseAmount / LottoRule.LOTTO_PRICE.getNumber();
    }
}
