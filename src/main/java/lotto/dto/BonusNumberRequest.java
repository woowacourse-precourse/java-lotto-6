package lotto.dto;

import lotto.validator.LottoNumberValidator;

public record BonusNumberRequest(Integer bonusNumber) {

    public BonusNumberRequest {
        LottoNumberValidator.validateLottoNumber(bonusNumber);
    }
}
