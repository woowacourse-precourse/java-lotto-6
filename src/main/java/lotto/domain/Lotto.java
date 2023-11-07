package lotto.domain;

import java.util.List;
import lotto.util.Util;
import lotto.util.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        String convert = Util.convertIntegerListToString(numbers);
        new LottoValidator().validate(convert);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
