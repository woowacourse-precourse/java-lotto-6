package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.BonusNumberException;
import lotto.utils.PurchaseAmountException;
import lotto.utils.WinningNumbersException;

import java.util.Arrays;

import static lotto.utils.GameMessage.*;

public class Input {
    private PurchaseAmountException purchaseAmountException = new PurchaseAmountException();
    private WinningNumbersException winningNumbersException = new WinningNumbersException();
    private BonusNumberException bonusNumberException = new BonusNumberException();
    private String winningNumbers = "";

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
                this.winningNumbers = Console.readLine();
                winningNumbersException.underLength(this.winningNumbers);
                winningNumbersException.exceedsLength(this.winningNumbers);
                winningNumbersException.notNumeric(this.winningNumbers);
                winningNumbersException.outsideRange(this.winningNumbers);
                winningNumbersException.duplicateNumber(this.winningNumbers);
                winningNumbersException.nonComma(this.winningNumbers);
                winningNumbersException.lastComma(this.winningNumbers);
                return this.winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputBonusNumber() {
        while (true) {
            try {
                System.out.println(BONUS_NUMBER.getMessage());
                String input = Console.readLine();
                bonusNumberException.outsideRange(input);
                bonusNumberException.duplicateNumber(Arrays.asList(change(this.winningNumbers)), input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String[] change(String winningNumbers) {
        String[] changeWinningNumbers = winningNumbers.split(",");
        return changeWinningNumbers;
    }
}
