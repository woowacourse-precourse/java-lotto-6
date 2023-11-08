package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;

public class InputView {
    public Amount inputAmount() {
        Amount amount = null;
        while (amount == null) {
            try {
                String input = Console.readLine();
                amount = new Amount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    public WinningNumber inputWinningNumber() {
        WinningNumber winningNumber = null;
        while (winningNumber == null) {
            try {
                String input = Console.readLine();
                winningNumber = new WinningNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumber;
    }

    public BonusNumber inputBonusNumber(WinningNumber winningNumber) {
        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            try {
                String input = Console.readLine();
                bonusNumber = new BonusNumber(winningNumber, input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }
}
