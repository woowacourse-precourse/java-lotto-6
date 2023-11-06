package lotto.Decorator;

import lotto.Controller.LottoController;
import lotto.DiContainer.DiContainer;
import lotto.Domain.Money;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Exception.CommonValidationException;
import lotto.Exception.LottoException;
import lotto.Exception.MoneyException;
import lotto.VIew.InputView;

public class LottoControllerDecorator extends LottoController {

    private DiContainer diContainer = DiContainer.of();
    private InputView inputView = diContainer.getInputView();

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
            } catch (MoneyException e) {
                System.err.println(e.getMessage());
            }
        } while (money == null);

        return money;
    }

    @Override
    public void createWinningLotto(WinningLotto winningLotto) {
        do {
            try {
                super.createWinningLotto(winningLotto);
            } catch (CommonValidationException | LottoException e) {
                System.err.println(e.getMessage());
            }
        } while (winningLotto.getLotto() == null);
    }

    @Override
    public void createWinningBonusNumber(WinningLotto winningLotto) {
        do {
            try {
                super.createWinningBonusNumber(winningLotto);
            } catch (CommonValidationException | LottoException e) {
                System.err.println(e.getMessage());
            }
        } while (winningLotto.getBonusNumber() == null);
    }
}

