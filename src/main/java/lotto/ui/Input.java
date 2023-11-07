package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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
        System.out.println("구입 금액을 입력해주세요.");
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

    public List<Integer> askWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해주세요. (숫자 6개 입력)");
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

    public int askBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        return converter.convertToBonusNumber(Console.readLine());
    }
}
