package lotto.view;

import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.utils.ExceptionHandler;

public class ProxyInputView implements Viewable {

    private final Viewable viewable;

    public ProxyInputView(Viewable viewable) {
        this.viewable = viewable;
    }

    @Override
    public Money getMoneyInput() {
        return ExceptionHandler.input(viewable::getMoneyInput);
    }

    @Override
    public Bonus getBonusInput() {
        return ExceptionHandler.input(viewable::getBonusInput);
    }

    @Override
    public WinningLotto getWinningInput() {
        return ExceptionHandler.input(viewable::getWinningInput);
    }

}
