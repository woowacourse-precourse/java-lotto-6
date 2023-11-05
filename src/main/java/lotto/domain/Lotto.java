package lotto.domain;

import lotto.util.ErrorThrower;
import lotto.util.validation.LottoValidation;

import java.util.List;

import static lotto.config.ErrorMessage.LOTTO_NEED_SIX_NUMBER_ERROR;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        LottoValidation lottoValidation = new LottoValidation();

        if (numbers.size() != 6) {
            ErrorThrower.throwIllegalArgumentException(LOTTO_NEED_SIX_NUMBER_ERROR.getMessage());
        }

        lottoValidation.validatorDuplicatedNumber(numbers);
        lottoValidation.validatorExceededRange(numbers);
    }

    // TODO: 추가 기능 구현
}
