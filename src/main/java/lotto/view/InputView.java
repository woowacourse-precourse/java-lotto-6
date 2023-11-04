package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.validator.BasicValidator;

public class InputView {

    private static final String COMMA = ",";
    private final BasicValidator<String> moneyInputValidator;
    private final BasicValidator<String> bonusNumberInputValidator;
    private final BasicValidator<String> winningNumbersInputValidator;

    public InputView(
            BasicValidator<String> moneyInputValidator,
            BasicValidator<String> bonusNumberInputValidator,
            BasicValidator<String> winningNumbersInputValidator
    ) {
        this.moneyInputValidator = moneyInputValidator;
        this.bonusNumberInputValidator = bonusNumberInputValidator;
        this.winningNumbersInputValidator = winningNumbersInputValidator;
    }

    public int inputMoney() {
        String input = Console.readLine();
        moneyInputValidator.validate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        winningNumbersInputValidator.validate(input);
        return Stream.of(input.split(COMMA))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        bonusNumberInputValidator.validate(input);
        return Integer.parseInt(input);
    }
}
