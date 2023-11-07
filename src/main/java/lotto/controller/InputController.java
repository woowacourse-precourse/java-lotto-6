package lotto.controller;

import java.util.Optional;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class InputController {
    public Money getMoney() {
        Optional<Money> money;
        do {
            money = checkMoney();
        } while(money.isEmpty());
        return money.get();
    }

    private Optional<Money> checkMoney() {
        try {
            return Optional.of(new Money(Input.inputMoneyGuide()));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return Optional.empty();
        }
    }

    public Lotto getWinningNumbers() {
        Optional<Lotto> lotto;
        do {
            lotto = checkLotto();
        } while (lotto.isEmpty());
        return lotto.get();
    }

    private Optional<Lotto> checkLotto() {
        try {
            return Optional.of(new Lotto(Input.inputWinningNumbersGuide()));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return Optional.empty();
        }
    }

    public BonusNumber getBonusNumber(Lotto winningLotto) {
        Optional<BonusNumber> bonusNumber;
        do {
            bonusNumber = checkBonusNumber(winningLotto);
        } while (bonusNumber.isEmpty());
        return bonusNumber.get();
    }

    private Optional<BonusNumber> checkBonusNumber(Lotto winningLotto) {
        try {
            BonusNumber bonusNumber = new BonusNumber(Input.inputBonusNumberGuide());
            new WinningLotto(winningLotto, bonusNumber);
            return Optional.of(bonusNumber);
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return Optional.empty();
        }
    }

}
