package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public Integer purchaseAmount() {
        String input = Console.readLine();
        numberValidation(input);
        return Integer.parseInt(input);
    }

    public List<Integer> winningNumbers() {
        String winningStringNumbers = Console.readLine();
        List<String> stringNumbersList = Arrays.asList(winningStringNumbers.split("\\s*,\\s*"));
        listValidation(stringNumbersList);

        List<Integer> winningNumbers = stringNumbersList.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public Integer bonusNumber() {
        String input = Console.readLine();
        numberValidation(input);
        return Integer.parseInt(input);
    }

    private void numberValidation(String input) {
        isNull(input);
        isNumeric(input);
    }

    private void listValidation(List<String> input) {
        for (String s : input) {
            isNumeric(s);
        }
    }

    private void isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.CHAR_STRING.getMessage());
            }
        }
    }

    private void isNull(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
    }
}
