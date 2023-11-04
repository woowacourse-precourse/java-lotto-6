package lotto.controller;

import lotto.domain.Budget;
import lotto.view.InputView;

public class LottoController {

    public void runMachine(){
        buyLotto();
    }

    private void buyLotto(){
        Budget budget = Budget.from(InputView.getBudgetInput());
    }
}
