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
    public Money inputMoney() {
        Money money = null;
        do {
            try {
                money = super.inputMoney();
            } catch (MoneyException | CommonValidationException e) {
                System.out.println(e.getMessage());
            }
        } while (money == null);

        return money;
    }

    @Override
    public void inputLottoNumber(WinningLotto winningLotto) {
        do {
            try {
                super.inputLottoNumber(winningLotto);
            } catch (CommonValidationException | LottoException e) {
                System.out.println(e.getMessage());
            }
        } while (winningLotto.getLotto() == null);
    }

    @Override
    public void inputWinningBonusNumber(WinningLotto winningLotto) {
        do {
            try {
                super.inputWinningBonusNumber(winningLotto);
            } catch (CommonValidationException | LottoException e) {
                System.out.println(e.getMessage());
            }
        } while (winningLotto.getBonusNumber() == null);
    }
}

