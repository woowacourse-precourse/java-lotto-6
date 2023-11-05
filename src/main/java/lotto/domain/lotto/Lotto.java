package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.validator.domain.LottoNumbersValidator;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createFrom(final List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public int extractSameCount(final Lotto compareLotto) {
        return (int) numbers.stream()
                .filter(compareLotto::contains)
                .count();
    }
}
