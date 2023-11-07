package lotto.controller;

import static lotto.Utils.convertIntegerList;
import static lotto.model.WinningLottoValidator.validateWinningLotto;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputMoney;
import static lotto.view.InputView.inputWinningNumber;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Store;
import lotto.model.User;
import lotto.model.WinningLotto;

public class InputController {
    public static User makeUser() {
        Money money = makeMoney();
        Store store = makeStore(money);
        return new User(store.getLottoCount(), store.getLottoTickets());
    }

    private static Money makeMoney() {
        try {
            Money money = new Money(inputMoney());
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeMoney();
        }
    }

    private static Store makeStore(Money money) {
        try {
            Store store = new Store(money);
            return store;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeStore(money);
        }
    }

    public static WinningLotto makeWinningLotto(Lotto winningNumbers) {
        try {
            WinningLotto winningLotto = new WinningLotto(winningNumbers, makeBonusNumber());
            return winningLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningLotto(winningNumbers);
        }
    }

    public static Lotto makeWinningNumbers() {
        try {
            String inputWinningNumber = inputWinningNumber();

            validateWinningLotto(inputWinningNumber);
            Lotto winningNumbers = new Lotto(convertIntegerList(inputWinningNumber));

            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningNumbers();
        }
    }

    private static BonusNumber makeBonusNumber() {
        try {
            BonusNumber bonusNumber = new BonusNumber(inputBonusNumber());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeBonusNumber();
        }
    }
}
