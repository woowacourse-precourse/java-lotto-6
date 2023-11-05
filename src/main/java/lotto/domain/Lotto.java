package lotto.domain;

import java.util.List;

public class Lotto {

    static final int NUMBER_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        List<Number> formattedNumbers = toNumberList(numbers);

        validate(formattedNumbers);
        this.numbers = formattedNumbers;
    }

    private List<Number> toNumberList(List<Integer> numbers) {
        return numbers.stream().map(Number::from).toList();
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

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(Number::getValue).toList();
    }
}
