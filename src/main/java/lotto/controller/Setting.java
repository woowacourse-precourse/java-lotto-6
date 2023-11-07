package lotto.controller;

import lotto.Util.Message;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Input;
import lotto.view.Output;

public class Setting {
    public static User getPayment() {
        Output.printRequestPayment();

        do {
            try {
                return new User(Input.inputPayment());
            } catch (IllegalArgumentException e) {
                System.out.println(Message
                        .PAYMENT_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }

    public static Lotto getLotto() {
        Output.printRequestWinningNumbers();

        do {
            try {
                return new Lotto(Input.inputLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(Message
                        .LOTTO_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }

    public static BonusNumber getBonusNumber(Lotto lotto) {
        Output.printRequestBonusNumber();

        do {
            try {
                return new BonusNumber(Input.inputBonusNumber(), lotto.numbers());
            } catch (IllegalArgumentException e) {
                System.out.println(Message
                        .BONUS_NUMBER_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }
}
