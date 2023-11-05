package lotto.domain;

import lotto.util.validator.LottoNumberValidator;

public record LottoNumber(int value) {

    public LottoNumber {
        LottoNumberValidator.validate(value);
    }
}
