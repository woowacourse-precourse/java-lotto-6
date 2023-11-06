package lotto.domain;

import java.util.List;

public class Lotto {

    static final int NUMBER_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> values) {
        List<Number> newNumbers = Number.getList(values);

        validate(newNumbers);
        this.numbers = newNumbers;
    }

    private void validate(List<Number> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
    }

    private void validateSize(List<Number> numbers) {
        if (isDifferentFormat(numbers.size())) {
            throw new IllegalArgumentException("로또는 숫자 %d개로 구성되어야 합니다".formatted(NUMBER_SIZE));
        }
    }

    private boolean isDifferentFormat(int numberSize) {
        return numberSize != NUMBER_SIZE;
    }

    private void validateDistinct(List<Number> numbers) {
        if (isOverlapped(numbers)) {
            throw new IllegalArgumentException("로또의 각 숫자는 중복되지 않아야 합니다");
        }
    }

    private boolean isOverlapped(List<Number> numbers) {
        return numbers.size() > countDistinctNumber(numbers);
    }

    private int countDistinctNumber(List<Number> numbers) {
        return (int) numbers.stream().distinct().count();
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public List<Integer> getValues() {
        return numbers.stream()
                .map(Number::getValue).toList();
    }

    @Override
    public String toString() {
        return "Lotto{numbers=%s}".formatted(numbers);
    }
}
