package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.validator.BasicValidator;
import lotto.validator.BonusNumberInputValidator;

public class InputView {
    private static final String COMMA = ",";

    private final BasicValidator<String> moneyInputValidator;
    private final BasicValidator<String> winningNumbersInputValidator;
    private final BonusNumberInputValidator bonusNumberInputValidator;

    public InputView(
            BasicValidator<String> moneyInputValidator,
            BasicValidator<String> winningNumbersInputValidator,
            BonusNumberInputValidator bonusNumberInputValidator
    ) {
        this.moneyInputValidator = moneyInputValidator;
        this.winningNumbersInputValidator = winningNumbersInputValidator;
        this.bonusNumberInputValidator = bonusNumberInputValidator;
    }

    public int inputMoney() {
        try {
            String input = Console.readLine();
            moneyInputValidator.validate(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputMoney();
        }
    }

    public List<Integer> inputWinningNumbers() {
        try {
            String input = Console.readLine();
            winningNumbersInputValidator.validate(input);
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
            bonusNumberInputValidator.validate(input, winningNumbers);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}
