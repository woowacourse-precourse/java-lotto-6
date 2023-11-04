package lotto.domain;

import java.util.List;

import static lotto.domain.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersRange(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }
}
