package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Payment;
import lotto.view.Input;

public class LottoProcedure {
    Payment payment;
    Lotto lotto;
    BonusNumber bonusNumber;

    public void startLotto() {
        payment = new Payment(Input.inputPayment());
        lotto = new Lotto(Input.inputLotto());
        bonusNumber = new BonusNumber(Input.inputBonusNumber());
    }
}
