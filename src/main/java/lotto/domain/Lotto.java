package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
