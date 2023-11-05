package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.Input;

public class InputController {
    private InputController() {}

    public static Money getMoney() {
        try {
            return new Money(Input.inputMoneyGuide());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    public static Lotto getWinningNumbers() {
        try {
            return new Lotto(Input.inputWinningNumbersGuide());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public static BonusNumber getBonusNumber() {
        try {
            return new BonusNumber(Input.inputBonusNumberGuide());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
