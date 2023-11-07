package lotto.domain;

import lotto.util.ErrorThrower;
import lotto.util.validation.LottoValidation;

import java.util.List;

import static lotto.config.ErrorMessage.LOTTO_NEED_SIX_NUMBER_ERROR;
import static lotto.config.ErrorMessage.LOTTO_OVER_SIX_NUMBER_ERROR;
import static lotto.config.LottoConfig.LOTTO_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        LottoValidation lottoValidation = new LottoValidation();

        if (numbers.size() > LOTTO_COUNT.getValue()) {
            ErrorThrower.throwIllegalArgumentException(LOTTO_OVER_SIX_NUMBER_ERROR.getMessage());
        }

        if (numbers.size() != LOTTO_COUNT.getValue()) {
            ErrorThrower.throwIllegalArgumentException(LOTTO_NEED_SIX_NUMBER_ERROR.getMessage());
        }

        lottoValidation.validatorDuplicatedNumber(numbers);
        lottoValidation.validatorExceededRange(numbers);
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
