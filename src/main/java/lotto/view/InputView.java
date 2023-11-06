package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine().trim();
        validateIsNumeric(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<String> winningNumbers = Arrays.stream(Console.readLine().trim().split(","))
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
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine().trim();
        validateIsNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
