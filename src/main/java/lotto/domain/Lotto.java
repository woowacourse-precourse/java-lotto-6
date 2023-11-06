package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.List;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        LottoNumberValidator.validateLottoSize(numbers);
        LottoNumberValidator.validateDuplication(numbers);
        LottoNumberValidator.validateNumberRangeInLotto(numbers);
    }
}
