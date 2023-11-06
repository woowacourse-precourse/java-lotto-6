package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameView {

    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    private void validatePurchaseAmount(String input) {
        String trimmed = input.trim();
        InputValidator.validateBlank(trimmed);
        InputValidator.validateNumbers(trimmed);
        InputValidator.validateIsMultipleOf1000(trimmed);
    }
}
