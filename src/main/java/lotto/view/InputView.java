package lotto.view;

import static lotto.message.ErrorMessage.NON_NUMERIC_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String READ_PURCHASE_AMOUNT = "구입금액을 입력후재세요.";
    private static final String READ_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final String READ_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine().trim();
        validateIsNumeric(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(READ_WINNING_NUMBERS);

        List<String> winningNumbers = Arrays.stream(Console.readLine().trim().split(DELIMITER))
                .map(String::trim)
                .toList();

        for (String winningNumber : winningNumbers) {
            validateIsNumeric(winningNumber);
        }

        return winningNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER);
        String bonusNumber = Console.readLine().trim();
        validateIsNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }
}
