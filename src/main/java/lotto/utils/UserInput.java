package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    public static String readPurchaseAmount() {
        ResultOutput.printMessage("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        validateNonNumeric(amount);
        return amount;
    }

    public static String readWinningNumbers() {
        ResultOutput.printMessage("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String readBonusNumber() {
        ResultOutput.printMessage("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();

        validateNonNumeric(bonus);
        return bonus;
    }

    public static List<String> splitNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> convertToNumbers(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로만 이루어진 값을 입력해주세요.");
        }
    }

    public static void validateUnit(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 숫자여야 합니다.");
        }
    }
}
