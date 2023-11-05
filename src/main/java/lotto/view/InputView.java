package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine().trim();
        validateIsNumeric(purchaseAmount);
        return purchaseAmount;
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public static List<String> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<String> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        for (String winningNumber : winningNumbers) {
            validateIsNumeric(winningNumber);
        }

        return winningNumbers;
    }
}
