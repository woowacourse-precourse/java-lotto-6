package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.messages.InputText;
import lotto.converter.InputConverter;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumber;

public class Input {
    InputConverter converter = new InputConverter();

    public Money askToPayAgainWhenError(Input input, Money money) {
        while (true) {
            try {
                money = new Money(input.askToPay());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private long askToPay() {
        System.out.println(InputText.ASK_PAYMENT);
        return converter.convertToMoney(Console.readLine());
    }

    public WinningNumber askWinningNumberAgainWhenError(Input input, WinningNumber winningNumber) {
        while (true) {
            try {
                winningNumber = new WinningNumber(input.askWinningNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber;
    }

    private List<Integer> askWinningNumber() {
        System.out.println();
        System.out.println(InputText.ASK_WINNIN_NUMBER);
        return converter.convertToWinningNumbers(Console.readLine());
    }

    public BonusNumber askBonusAgainWhenError(
            Input input, WinningNumber winningNumber, BonusNumber bonusNumber) {
        while (true) {
            try {
                bonusNumber = new BonusNumber(winningNumber.getWinningNumber(), input.askBonus());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private int askBonus() {
        System.out.println();
        System.out.println(InputText.ASK_BONUS_NUMBER);
        return converter.convertToBonusNumber(Console.readLine());
    }
}
