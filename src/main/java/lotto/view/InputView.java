package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getUserInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        InputValidator.validateNonSpaced(userInput);
        InputValidator.validateNonZeroLeadingDigits(userInput);
        try {
            int purchaseAmount = Integer.parseInt(userInput);
            validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력된 구입 금액이 너무 큽니다.");
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1_000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (purchaseAmount > 100_000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 100,000원을 초과할 수 없습니다.");
        }
        if (purchaseAmount % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
