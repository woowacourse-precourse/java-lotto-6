package lotto.dto.request;

import static lotto.common.ErrorMessages.NOT_A_NUMBER;
import static lotto.common.ErrorMessages.NULL_OR_EMPTY;
import static lotto.utils.StringUtils.isDigit;
import static org.junit.platform.commons.util.StringUtils.isBlank;

import lotto.exception.InputValidationException;

public class LottoPurchaseCostRequest {
    private String lottoPurchaseCost;

    public LottoPurchaseCostRequest(String lottoPurchaseCost) {
        validateMoney(lottoPurchaseCost);
        this.lottoPurchaseCost = lottoPurchaseCost;
    }

    private void validateMoney(String lottoPurchaseCost) {
        if (isBlank(lottoPurchaseCost)) {
            throw new InputValidationException(NULL_OR_EMPTY);
        }

        if (!isDigit(lottoPurchaseCost)) {
            throw new InputValidationException(NOT_A_NUMBER, lottoPurchaseCost);
        }
    }

    public String getLottoPurchaseCost() {
        return lottoPurchaseCost;
    }
}
