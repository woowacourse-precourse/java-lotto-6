package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.Validator.validateAmountInThousands;
import static lotto.util.Validator.validateDigit;

public class Input {
    public int readTotalPurchasedAmount() {
        String amountStr = Console.readLine();
        validateDigit(amountStr);
        int amount = Integer.parseInt(amountStr);
        validateAmountInThousands(amount);
        return amount;
    }
}
