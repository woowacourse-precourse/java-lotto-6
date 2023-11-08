package lotto.domain;

import static java.util.Collections.unmodifiableList;
import static lotto.utils.LottoValidateUtils.validateLottoNumbers;

import java.util.List;

public final class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .toList();
    }

    public List<Integer> numbers() {
        return unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
