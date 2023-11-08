package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputManager {

    public static String receiveUserInput() {
        return removeInputSpace(Console.readLine());
    }

    private static String removeInputSpace(String input) {
        return input.replaceAll(" ", "");
    }

    public static int bonusNumberInput(Lotto winningLotto) {
        String input = InputManager.receiveUserInput();

        InputValidator.validateIsNumeric(input);
        int bonusNumber = Integer.parseInt(input);
        InputValidator.validateIsLottoNumber(bonusNumber);
        InputValidator.validateBonusNumberNoDuplicate(winningLotto.getLottoNumber(), bonusNumber);

        return bonusNumber;
    }

    public static int purchaseAmountInput() {
        String input = InputManager.receiveUserInput();

        InputValidator.validateIsNumeric(input);
        int purchaseAmount = Integer.parseInt(input);
        InputValidator.validateDivision1000(purchaseAmount);

        return purchaseAmount / 1000;

    }

    public static List<Integer> winningLottoInput() {
        List<String> input = List.of(receiveUserInput().split(","));

        return input.stream()
                .map(number -> {
                    InputValidator.validateIsNumeric(number);
                    return Integer.parseInt(number);
                })
                .collect(Collectors.toList());
    }
}
