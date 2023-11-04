package lotto.domain;

import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.toList;
import static lotto.domain.WinningLotto.LOTTO_NUMBERS_SIZE;
import static lotto.view.constants.ConsoleMessage.DUPLICATE_NUMBER_ERROR;
import static lotto.view.constants.SeparatorConstant.LOTTO_NUMBERS_SEPARATOR;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    public boolean contains(Integer number) {
        return numbers.stream()
                .anyMatch(isEqual(number));
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(toList());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_NUMBERS_SIZE;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private String appendLottoNumbers() {
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < LOTTO_NUMBERS_SIZE; index++) {
            sb.append(numbers.get(index));

            if (index < LOTTO_NUMBERS_SIZE - 1) {
                sb.append(LOTTO_NUMBERS_SEPARATOR);
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("[%s]", appendLottoNumbers());
    }
}
