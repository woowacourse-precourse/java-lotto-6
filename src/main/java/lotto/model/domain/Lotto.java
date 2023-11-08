package lotto.model.domain;

import java.util.List;

import static lotto.util.constant.Constant.LOTTO_NUMBER_SIZE;
import static lotto.util.validate.InputValidate.validateRangeInputLottoNumbers;
import static lotto.util.validate.InputValidate.validateUniqueInputLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueInputLottoNumbers(numbers);
        validateRangeInputLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
}
