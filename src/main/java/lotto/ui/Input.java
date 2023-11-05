package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.InputValidation;

public class Input {
    public static char DELIMITER = ',';

    public static int readAmount(String input) {
        int amount = InputValidation.validateNumber(input);
        InputValidation.checkSufficient(amount);
        InputValidation.checkDivisible(amount);
        return amount;
    }

    public static List<Integer> readWinningNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        InputValidation.checkDelimiter(input);
        List<String> vocabulary = Arrays.asList(input.split(DELIMITER + ""));
        for (String word : vocabulary) {
            numbers.add(InputValidation.validateNumber(word));
        }
        return numbers;
    }
}
