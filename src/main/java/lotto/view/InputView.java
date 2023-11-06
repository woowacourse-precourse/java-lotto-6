package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.BusinessLogicException;
import lotto.exception.ExceptionMessage;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                return checkPurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private int checkPurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                throw new BusinessLogicException(ExceptionMessage.INVALID_NUMBER);
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new BusinessLogicException(ExceptionMessage.INVALID_NUMBER);
        }
    }
}
