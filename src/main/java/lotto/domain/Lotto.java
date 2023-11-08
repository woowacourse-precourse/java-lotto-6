package lotto.domain;

import java.util.List;
import lotto.service.Validator;
import lotto.utils.constants.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Validator.lottoNumberAndGet(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

