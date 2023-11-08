package lotto.domain;

import static lotto.validation.LottoValidator.validateLottoNumbersList;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersList(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
