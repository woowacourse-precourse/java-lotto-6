package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.Budget;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;

public class LottoController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void runMachine(){
        buyLotto();
    }

    private void buyLotto(){
        Budget budget = Budget.from(InputView.getBudgetInput());
        List<Lotto> lottos = lottoGenerator.generateMultipleLottoByBudget(budget);
    }
}
