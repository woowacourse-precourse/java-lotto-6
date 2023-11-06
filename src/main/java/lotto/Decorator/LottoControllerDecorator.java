package lotto.Decorator;

import lotto.Controller.LottoController;
import lotto.Domain.Money;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Exception.CommonValidationException;
import lotto.Exception.LottoException;
import lotto.Exception.MoneyException;

public class LottoControllerDecorator extends LottoController {


    private LottoControllerDecorator() {
        super();
    }

    public static LottoControllerDecorator of() {
        return new LottoControllerDecorator();
    }

    @Override
    public Money getMoney() {
        Money money = null;
        do {
            try {
                money = super.getMoney();
            } catch (MoneyException | CommonValidationException e) {
                System.out.println(e.getMessage());
            }
        } while (money == null);

        return money;
    }

    @Override
    public void createWinningLottoNumber(WinningLotto winningLotto) {
        do {
            try {
                super.createWinningLottoNumber(winningLotto);
            } catch (CommonValidationException | LottoException e) {
                System.out.println(e.getMessage());
            }
        } while (winningLotto.getLotto() == null);
    }

    @Override
    public void createWinningBonusNumber(WinningLotto winningLotto) {
        do {
            try {
                super.createWinningBonusNumber(winningLotto);
            } catch (CommonValidationException | LottoException e) {
                System.out.println(e.getMessage());
            }
        } while (winningLotto.getBonusNumber() == null);
    }
}

