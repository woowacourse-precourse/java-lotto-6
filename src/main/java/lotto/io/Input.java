package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.validation.InputValidator;

public class Input {
    public static int purchaseAmount() {
        String input = Console.readLine();
        InputValidator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> winningNumbers() {
        String input = Console.readLine();
        InputValidator.validateWinningNumbersFormat(input);
        List<Integer> winningNumbers = Stream.of(input.split(","))
            .map(Integer::parseInt)
            .toList();
        InputValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int bonusNumber() {
        String input = Console.readLine();
        InputValidator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
