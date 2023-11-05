package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static int readPurchaseAmount() {
        String amount = Console.readLine();
        validateBlank(amount);
        return validateInteger(amount);
    }

    public static List<Integer> readWinnerLottoNumber() {
        String numbers = Console.readLine();
        validateBlank(numbers);
        return splitWord(numbers);
    }

    public static int readBonusNumber() {
        String bonusNumber = Console.readLine();
        validateBlank(bonusNumber);
        return validateInteger(bonusNumber);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이 입력되었습니다.");
        }
    }

    private static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static List<Integer> splitWord(String input) {
        return Arrays.stream(input.split(","))
                .map(InputView::validateInteger)
                .collect(Collectors.toList());
    }
}
