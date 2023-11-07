package lotto.domain;

import lotto.utils.Validator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.checkPublishLottoNumber(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
