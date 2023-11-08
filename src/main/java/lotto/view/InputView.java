package lotto.view;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputCSVNumbersValidator;
import lotto.validator.InputNumberValidator;

public class InputView {
    private InputView() {
    }

    public static int inputPurchaseAmount() {
        String input = Console.readLine();
        InputNumberValidator.validate(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputWinningNumbers() {
        List<String> inputs = Arrays.stream(Console.readLine().split(",")).toList();
        InputCSVNumbersValidator.validate(inputs);
        return inputs.stream().map(Integer::parseInt).toList();

    }

    public static int inputBonusNumber() {
        String input = Console.readLine();
        InputNumberValidator.validate(input);
        return Integer.parseInt(input);
    }
}
