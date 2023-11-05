package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Budget;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private Budget budget;

    public void runMachine(){
        Lottos userLottos = buyLotto();
        WinningLotto winningLotto = drawLotto();
        WinningStatistics winningStatistics = makeStatistics(userLottos, winningLotto);
    }

    private Lottos buyLotto(){
        budget = Budget.from(InputView.getBudgetInput());
        Lottos userMultipleLottos = lottoGenerator.generateLottosByBudget(budget);
        OutputView.printUserLottos(userMultipleLottos, budget);
        return userMultipleLottos;
    }

    private WinningLotto drawLotto(){
        InputView.printRequireWinningNumbersMessage();
        Lotto lotto = lottoGenerator.generateWinningLotto();
        Bonus bonus = Bonus.from(InputView.getBonusInput());
        return WinningLotto.of(lotto, bonus);
    }

    private WinningStatistics makeStatistics(Lottos userLottos, WinningLotto winningLotto){
        return WinningStatistics.from(userLottos, winningLotto, budget);
    }
}
