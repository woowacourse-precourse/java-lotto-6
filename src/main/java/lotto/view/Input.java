package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.PurchaseAmountException;
import lotto.utils.WinningNumbersException;

import static lotto.utils.GameMessage.*;

public class Input {
    PurchaseAmountException purchaseAmountException = new PurchaseAmountException();
    WinningNumbersException winningNumbersException = new WinningNumbersException();

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
        while (true) {
            try {
                System.out.println(WINNING_NUMBERS.getMessage());
                String input = Console.readLine();
                winningNumbersException.underLength(input);
                winningNumbersException.exceedsLength(input);
                winningNumbersException.notNumeric(input);
                winningNumbersException.outsideRange(input);
                winningNumbersException.duplicateNumber(input);
                winningNumbersException.nonComma(input);
                winningNumbersException.lastComma(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputBonusNumber() {
        // 보너스 번호 입력
        System.out.println(BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
