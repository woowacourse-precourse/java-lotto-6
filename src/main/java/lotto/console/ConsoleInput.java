package lotto.console;

import static lotto.constant.LottoMessage.REQUEST_INPUT_PURCHASE_AMOUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {
    public static String readPurchaseAmount() {
        System.out.println(REQUEST_INPUT_PURCHASE_AMOUNT_MESSAGE);

        String purchaseAmount = Console.readLine();

        validateInput(purchaseAmount);

        return purchaseAmount;
    }

    private static void validateInput(String input) {
        checkBlank(input);
        checkSpacing(input);
    }

    private static void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
        }
    }

    private static void checkSpacing(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 공백을 포함할 수 없습니다.");
        }
    }
}
