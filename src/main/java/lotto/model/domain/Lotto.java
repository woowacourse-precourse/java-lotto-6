package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.validate.InputValidate;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.util.validate.InputValidate.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueInputLottoNumbers(numbers);
        validateRangeInputLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
}
