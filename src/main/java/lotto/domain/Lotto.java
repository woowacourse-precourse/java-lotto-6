package lotto.domain;

import static lotto.util.Validator.validateDuplicate;
import static lotto.util.Validator.validateNonNumericNumbers;
import static lotto.util.Validator.validateRangeOfNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRangeOfNumbers(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String number) {
        this.numbers = transformInputNumber(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> convertStringToList(String input) {
        List<String> numbers = new ArrayList<>(Arrays.asList(input.split(",")));
        return numbers;
    }

    private List<Integer> convertStringToInt(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : input) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    private List<Integer> transformInputNumber(String input) {
        List<String> numbers = convertStringToList(input);
        validateNonNumericNumbers(numbers);
        return convertStringToInt(numbers);
    }
}
