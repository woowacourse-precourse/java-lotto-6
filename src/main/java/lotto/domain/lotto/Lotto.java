package lotto.domain.lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.utils.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    public Collection<Integer> getLotto() {
        return Collections.unmodifiableCollection(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateSize(numbers);
        LottoValidator.validateDuplicateNumber(numbers);
        LottoValidator.validateRangeOfNumber(numbers);
    }
}
