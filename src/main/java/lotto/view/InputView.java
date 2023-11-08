package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.enums.Message;
import lotto.model.User;
import lotto.util.InputCheck;

public class InputView {
    InputCheck inputCheck = new InputCheck();

    public void inputPaymentAmount(User user) {
        Message.AMOUNT_INPUT.getMessage();
        while (true) {
            try {
                int paymentAmount = inputCheck.checkPaymentAmount(Console.readLine());
                user.setPaymentAmount(paymentAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputWinningNumber(User user) {
        Message.WINNING_NUMBERS_INPUT.getMessage();
        while (true) {
            try {
                Lotto lotto = inputCheck.checkWinningNumber(Console.readLine());
                user.setWinningNumber(lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber(User user) {
        Message.BONUS_INPUT.getMessage();
        while (true) {
            try {
                int bonusNumber = inputCheck.checkBonusNumber(Console.readLine(), user.getWinningNumber());
                user.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
