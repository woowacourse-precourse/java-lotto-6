package lotto.domain.dto.input;

import lotto.validator.PurchaseAmountValidator;

public record PurchaseLottoDto(int amount) {
    public PurchaseLottoDto {
        PurchaseAmountValidator.checkAmountRange(amount);
        PurchaseAmountValidator.checkRemainder(amount);
    }
}
