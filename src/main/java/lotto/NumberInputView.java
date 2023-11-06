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
//        sortingNumbers();
    }

    public List<Integer> getValidNumbers() {
        return validNumbers;
    }

    private void validate() {
        String input = Console.readLine();
        integrating(input);
        try {
//            validateLength();
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
}
