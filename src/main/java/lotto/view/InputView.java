package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.validator.BasicValidator;

public class InputView {

    private final BasicValidator<String> moneyInputValidator;

    public InputView(BasicValidator<String> moneyInputValidator) {
        this.moneyInputValidator = moneyInputValidator;
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
        return Integer.parseInt(input);
    }
}
