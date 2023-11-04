package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class Input {
    public int inputUserPayment() {
        String payment = Console.readLine();

        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages
                    .NON_NUMERIC_INPUT
                    .getMessage());
        }
    }

    public List<Integer> inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        List<String> splittedNumbers = splitNumbers(winningNumbers);
        return numbersToInteger(splittedNumbers);
    }

    public List<String> splitNumbers(String winningNumbers) {
        return List.of(winningNumbers.split(","));
    }

    public List<Integer> numbersToInteger(List<String> winningNumbers) {
        List<Integer> integerWinningNumbers = new ArrayList<>();

        for (String number : winningNumbers) {
            try {
                integerWinningNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessages
                       .NON_NUMERIC_INPUT
                       .getMessage());
            }
        }
        return integerWinningNumbers;
    }
}
