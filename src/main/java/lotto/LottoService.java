package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoService {
    private static final int LIMIT_NUMBER = 45;
    private static final int PURCHASE_STANDARD = 1000;

    public int inputPurchaseAmount() {
        while (true) {
            String input = Console.readLine();
            try {
                containsNonNumericCharacters(input);
                isPurchaseAmountDivideBy1000(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void containsNonNumericCharacters(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_NON_NUMERIC_CHARACTERS.getMessage());
        }
    }

    private void isPurchaseAmountDivideBy1000(String input) {
        if (Integer.parseInt(input)% PURCHASE_STANDARD > 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_NOT_DIVIDE_BY_1000.getMessage());
        }
    }
}
