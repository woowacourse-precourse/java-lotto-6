package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Budget;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void runMachine(){
        buyLotto();
    }

    private void buyLotto(){
        Budget budget = Budget.from(InputView.getBudgetInput());
        Lottos lottos = Lottos.from(lottoGenerator.generateMultipleLottoByBudget(budget));
    }
}
