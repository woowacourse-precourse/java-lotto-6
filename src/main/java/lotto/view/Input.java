package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.PurchaseAmountException;

import static lotto.utils.GameMessage.*;

public class Input {
    PurchaseAmountException purchaseAmountException = new PurchaseAmountException();

    public String inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT.getMessage());
                String input = Console.readLine();
                purchaseAmountException.notNumeric(input);
                purchaseAmountException.notDivisible(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputWinningNumber() {
        // 당첨 번호 입력
        System.out.println(WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        // 보너스 번호 입력
        System.out.println(BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
