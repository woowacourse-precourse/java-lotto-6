package lotto.view;

import java.util.List;
import lotto.common.InputUtils;
import lotto.lotto.WinningNumber;
import lotto.message.Message;
import lotto.money.Money;

public class InputView {

    private InputView() {
    }

    public static Money inputMoney() {
        while (true) {
            System.out.println(Message.INPUT_MONEY);
            try {
                int amount = InputUtils.getNumber();
                return new Money(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumber inputWinningNumber() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputWinningNumbers();
                int bonusNumber = inputBonusNumber();
                return new WinningNumber(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println(Message.INPUT_BONUS_NUMBER);
                return InputUtils.getNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println(Message.INPUT_WINNING_NUMBERS);
                return InputUtils.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
