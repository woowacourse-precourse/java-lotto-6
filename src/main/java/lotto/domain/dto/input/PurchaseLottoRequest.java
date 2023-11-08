package lotto.domain.dto.input;

import lotto.validator.PurchaseAmountValidator;

public record PurchaseLottoRequest(int amount) {
    public PurchaseLottoRequest {
        PurchaseAmountValidator.checkAmountRange(amount);
        PurchaseAmountValidator.checkRemainder(amount);
    }
}
