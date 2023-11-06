package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import lotto.validator.WinningValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int readPurchaseAmount() {
        String input = Console.readLine();
        InputValidator.validate(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        return convertInputToList(input);
    }

    public static int readBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private static List<Integer> convertInputToList(String input) {
        String[] extractNumbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : extractNumbers) {
            WinningValidator.validateNonNumber(number);
            winningNumbers.add(Integer.parseInt(number));
        }
        WinningValidator.validate(winningNumbers);
        return winningNumbers;
    }
}
