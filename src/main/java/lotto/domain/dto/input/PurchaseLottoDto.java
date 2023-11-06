package lotto.domain.dto.input;

import lotto.validator.PurchaseLottoValidator;

public record PurchaseLottoDto(int amount) {
    public PurchaseLottoDto {
        PurchaseLottoValidator.checkAmountRange(amount);
        PurchaseLottoValidator.checkRemainder(amount);
    }
}
