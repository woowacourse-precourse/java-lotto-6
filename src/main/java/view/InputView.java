package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String userInput = Console.readLine().trim();
        System.out.println();
        return validateNumber(userInput);
    }

    public static List<Integer> askWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String num : Console.readLine().trim().split(",")) {
            winningNumbers.add(validateNumber(num));
        }
        System.out.println();
        return winningNumbers;
    }

    public static int askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        String userInput = Console.readLine().trim();
        System.out.println();
        return validateNumber(userInput);
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 숫자가 아닙니다.");
        }
    }
}
