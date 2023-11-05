package lotto.controller;

import lotto.ErrorMessages;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Input;
import lotto.view.Output;

public class Setting {
    public static User getPayment() {
        Output.printRequestPayment();
        User user;

        do {
            try {
                user = new User(Input.inputPayment());
                return user;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages
                        .PAYMENT_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }

    public static Lotto getLotto() {
        Output.printRequestWinningNumbers();
        Lotto lotto;

        do {
            try {
                lotto = new Lotto(Input.inputLotto());
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages
                        .LOTTO_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }

    public static BonusNumber getBonusNumber(Lotto lotto) {
        Output.printRequestBonusNumber();
        BonusNumber bonusNumber;

        do {
            try {
                bonusNumber = new BonusNumber(Input.inputBonusNumber(), lotto.numbers());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessages
                        .BONUS_NUMBER_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }
}
