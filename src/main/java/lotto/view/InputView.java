package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Message;
import lotto.util.InputCheck;

public class InputView {
    InputCheck inputCheck = new InputCheck();

    public void inputPaymentAmount() {
        Message.AMOUNT_INPUT.getMessage();
        while (true) {
            try {
                inputCheck.checkPaymentAmount(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputWinningNumber() {
        Message.WINNING_NUMBERS_INPUT.getMessage();
        while (true) {
            try {
                inputCheck.checkWinningNumber(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        Message.BONUS_INPUT.getMessage();
        while (true) {
            try {
                inputCheck.checkBonusNumber(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
