package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.validation.InputValidator;

public class Input {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        InputValidator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateWinningNumbersFormat(input);
        List<Integer> winningNumbers = Stream.of(input.split(","))
            .map(Integer::parseInt)
            .toList();
        InputValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int bonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
