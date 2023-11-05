package lotto.domain.dto.input;

import lotto.validator.LottoQuantityValidator;

public record PurchaseLottoDto(int amount) {
    public PurchaseLottoDto {
        LottoQuantityValidator.checkAmountRange(amount);
        LottoQuantityValidator.checkRemainder(amount);
    }
}
