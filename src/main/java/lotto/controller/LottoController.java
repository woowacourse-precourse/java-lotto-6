package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Budget;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void runMachine(){
        Lottos userLottos = buyLotto();
        WinningLotto winningLotto = drawLotto();
    }

    private Lottos buyLotto(){
        Budget budget = Budget.from(InputView.getBudgetInput());
        Lottos userMultipleLottos = Lottos.from(lottoGenerator.generateMultipleLottoByBudget(budget));
        OutputView.printUserLottos(userMultipleLottos, budget);
        return userMultipleLottos;
    }

    private WinningLotto drawLotto(){
        // TODO: 당첨 로또 및 보너스 번호 생성
    }
}
