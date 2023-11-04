package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class InputView {
    public int inputUserPayment() {
        String payment = Console.readLine();
        return numberToInteger(payment);
    }

    public int numberToInteger(String payment) {
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
        List<String> splitNumbers = splitNumbersByComma(winningNumbers);
        return winningNumbersToInteger(splitNumbers);
    }

    public List<String> splitNumbersByComma(String splitNumbers) {
        return List.of(splitNumbers.split(","));
    }

    public List<Integer> winningNumbersToInteger(List<String> winningNumbers) {
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

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return numberToInteger(bonusNumber);
    }
}
