package lotto.domain.dto;

import lotto.validator.BonusNumberValidator;

public record BonusNumberDto(int number) {
    public BonusNumberDto {
        BonusNumberValidator.validateBonusNumber(number);
    }
}
