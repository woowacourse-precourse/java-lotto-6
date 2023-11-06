package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.validator.BonusNumberInputValidator;
import lotto.validator.MoneyInputValidator;
import lotto.validator.WinningNumbersInputValidator;

public class InputView {
    private static final String COMMA = ",";

    public int inputMoney() {
        try {
            String input = Console.readLine();
            MoneyInputValidator.validate(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputMoney();
        }
    }

    public List<Integer> inputWinningNumbers() {
        try {
            String input = Console.readLine();
            WinningNumbersInputValidator.validate(input);
            return Stream.of(input.split(COMMA))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbers();
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        try {
            String input = Console.readLine();
            BonusNumberInputValidator.validate(input, winningNumbers);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}
