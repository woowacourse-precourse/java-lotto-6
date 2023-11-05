package lotto.view;

import camp.nextstep.edu.missionutils.Console;

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
}
