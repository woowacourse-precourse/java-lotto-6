package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.util.Const.*;
import static lotto.util.ValidateMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> stringToList(String winningNumber) {
        return Stream.of(winningNumber.split(SEPARATOR))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validate(List<Integer> inputList) {
        validateNumber(inputList);
        validateCommaString(inputList);
        validateSize(inputList);
        validateUnique(inputList);
    }

    private static void validateSize(List<Integer> inputList) {
        if (inputList.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE_MESSAGE);
        }
    }

    private static void validateUnique(List<Integer> inputList) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : inputList) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_UNIQUE_MESSAGE);
            }
        }
    }

    private static void validateCommaString(List<Integer> inputList) {
        String inputString = inputList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));

        if (!inputString.matches(INPUT_LOTTO_TYPE)) {
            throw new IllegalArgumentException(ERROR_COMMA_MESSAGE);
        }
    }

    private static void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_MESSAGE);
            }
        }
    }


    public List<Integer> getNumber() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
