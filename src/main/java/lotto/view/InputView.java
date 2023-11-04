package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.validator.BasicValidator;

public class InputView {

    private final BasicValidator<String> moneyInputValidator;
    private final BasicValidator<String> bonusNumberInputValidator;

    public InputView(BasicValidator<String> moneyInputValidator, BasicValidator<String> bonusNumberInputValidator) {
        this.moneyInputValidator = moneyInputValidator;
        this.bonusNumberInputValidator = bonusNumberInputValidator;
    }

    public int inputMoney() {
        String input = Console.readLine();
        moneyInputValidator.validate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        bonusNumberInputValidator.validate(input);
        return Integer.parseInt(input);
    }
}
