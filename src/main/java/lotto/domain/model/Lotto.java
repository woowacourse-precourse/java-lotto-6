package lotto.domain.model;

import java.util.List;

import static lotto.domain.constant.ErrorConst.LOTTO_COUNT_NOT_SIX;
import static lotto.domain.constant.ErrorConst.LOTTO_HAS_DUPLICATE;
import static lotto.domain.constant.ErrorConst.LOTTO_OUT_OF_RANGE;
import static lotto.domain.constant.LottoConst.COUNT;
import static lotto.domain.constant.LottoConst.HIGHEST_NUMBER;
import static lotto.domain.constant.LottoConst.LOWEST_NUMBER;
import static lotto.domain.validation.Validator.checkCondition;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkCondition(numbers.stream().anyMatch(
                        number -> number < LOWEST_NUMBER
                                || number > HIGHEST_NUMBER),
                LOTTO_OUT_OF_RANGE);
        checkCondition(numbers.size() != COUNT,
                LOTTO_COUNT_NOT_SIX);
        checkCondition(numbers.stream().distinct().count() != COUNT,
                LOTTO_HAS_DUPLICATE);
    }

}
