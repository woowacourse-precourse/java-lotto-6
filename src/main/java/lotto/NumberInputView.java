package lotto;

import static lotto.ErrorMessage.LEAST_ONE_ISSUE_ERROR;
import static lotto.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR;
import static lotto.ErrorMessage.NUMBER_SIZE_ERROR;
import static lotto.ErrorMessage.NUMERIC_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberInputView {
    private static final int INPUT_DIGIT_FIRST = 1;
    private static final int INPUT_DIGIT_LAST = 45;
    private static final int COLUMN = 6;
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    private List<String> numbers;
    private List<Integer> validNumbers;

    public NumberInputView() {
        validate();
        sortingNumbers();
    }

    public List<Integer> getValidNumbers() {
        return validNumbers;
    }

    private void validate() {
        String input = Console.readLine();
        try {
            integrating(input);
            validateLength();
            validateNumerics();
            validationDuplicate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validate();
        }
    }

    private void integrating(String input) {
        try {
            this.numbers = Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
        if (numbers.contains(EMPTY)) {
            throw new IllegalArgumentException(LEAST_ONE_ISSUE_ERROR);
        }
    }

    private void validateLength() {
        if (numbers.size() != COLUMN) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
        }
    }

    private void validateNumerics() {
        numbers.stream().filter(str -> !isDigit(str)).forEach(str -> {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        });
    }

    private boolean isDigit(String str) {
        int value = Integer.parseInt(str);
        return INPUT_DIGIT_FIRST <= value && value <= INPUT_DIGIT_LAST;
    }

    private void validationDuplicate() {
        boolean hasDuplicates = numbers.stream()
                .map(Integer::parseInt)
                .distinct()
                .count() < numbers.size();
        if (hasDuplicates) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private void sortingNumbers() {
        validNumbers = numbers.stream()
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
