package lotto.domain;

import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.toList;
import static lotto.view.constants.SeparatorConstant.LOTTO_NUMBERS_SEPARATOR;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Integer number) {
        return numbers.stream()
                .anyMatch(isEqual(number));
    }

    public int countMatchingNumbers(List<Integer> targetNumbers) {
        long count = targetNumbers.stream()
                .filter(this::compareNumbers)
                .count();

        return Long.valueOf(count).intValue();
    }

    @Override
    public String toString() {
        return String.format("[%s]", appendLottoNumbers());
    }

    private boolean compareNumbers(Integer number) {
        return numbers.stream()
                .anyMatch(isEqual(number));
    }

    private String appendLottoNumbers() {
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < numbers.size(); index++) {
            sb.append(numbers.get(index));

            if (index < numbers.size() - 1) {
                sb.append(LOTTO_NUMBERS_SEPARATOR);
            }
        }

        return sb.toString();
    }
}
