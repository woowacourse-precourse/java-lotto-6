package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberInputView {
    private static final int INPUT_DIGIT_FIRST = 1;
    private static final int INPUT_DIGIT_LAST = 45;
    private static final int COLUMN = 6;
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
        integrating(input);
        try {
            validateLength();
            validateNumerics();
            validationDuplicate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validate();
        }
    }

    private void integrating(String input) {
        this.numbers = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateLength() {
        if (numbers.size() != COLUMN) {
            throw new IllegalArgumentException("[ERROR] : 6자리 숫자를 입력해주세요.");
        }
    }

    private void validateNumerics() {
        numbers.stream().filter(str -> !isDigit(str)).forEach(str -> {
            throw new IllegalArgumentException("[ERROR] : 숫자를 입력해주세요.");
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
            throw new IllegalArgumentException("[ERROR] : 중복된 숫자가 존재합니다.");
        }
    }

    private void sortingNumbers() {
        validNumbers = numbers.stream()
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
