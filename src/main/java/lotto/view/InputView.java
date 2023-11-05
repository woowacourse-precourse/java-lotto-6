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
        String input = Console.readLine();
        MoneyInputValidator.validate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        WinningNumbersInputValidator.validate(input);
        return Stream.of(input.split(COMMA))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        BonusNumberInputValidator.validate(input);
        return Integer.parseInt(input);
    }
}
