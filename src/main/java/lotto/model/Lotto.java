package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        printNumbers(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void printNumbers(List<Integer> numbers){
        final String LEFT_BRACKET = "[";
        final String RIGHT_BRACKET = "]";

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        String numbersWithComma = sortedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(LEFT_BRACKET + numbersWithComma + RIGHT_BRACKET);
    }

    // TODO: 추가 기능 구현
}
