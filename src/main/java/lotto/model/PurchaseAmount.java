package lotto.model;

import lotto.constants.ErrorMessages;
import lotto.constants.LottoNumberLimits;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int inputMoney) {
        validate(inputMoney);
        this.purchaseAmount = inputMoney;
    }

    private void validate(int inputMoney) {
        checkLeastLottoPrice(inputMoney);
        checkMultipleOfThousand(inputMoney);
    }

    private void checkMultipleOfThousand(int inputMoney) {
        if (isNotMultipleOfThousand(inputMoney)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_MULTIPLE_OF_THOUSAND_MESSAGE);
        }
    }

    private boolean isNotMultipleOfThousand(int inputMoney) {
        return inputMoney % LottoNumberLimits.LOTTO_PRICE != 0;
    }

    private void checkLeastLottoPrice(int inputMoney) {
        if (inputMoney < LottoNumberLimits.LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_LEAST_PRICE_ERROR_MESSAGE);
        }
    }

    public int getMaxLottoCountForBudget() {
        return this.purchaseAmount / LottoNumberLimits.LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

}
