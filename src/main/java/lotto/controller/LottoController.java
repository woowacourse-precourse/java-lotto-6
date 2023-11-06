package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Budget;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.UserLottoGenerateStrategy;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoGenerateStrategy;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Budget budget;

    public void runMachine(){
        Lottos userLottos = buyLotto();
        WinningLotto winningLotto = drawLotto();
        WinningStatistics winningStatistics = makeStatistics(userLottos, winningLotto);
        OutputView.printWinningStaticstics(winningStatistics);
    }

    private Lottos buyLotto(){
        try {
            budget = Budget.from(InputView.getBudgetInput());
            Lottos userMultipleLottos = new LottoGenerator(new UserLottoGenerateStrategy()).generateLottosByBudget(budget);
            OutputView.printUserLottos(userMultipleLottos, budget);
            return userMultipleLottos;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    private WinningLotto drawLotto(){
        try {
            Lotto lotto = getWinningLotto();
            Bonus bonus = getBonus();
            return WinningLotto.of(lotto, bonus);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return drawLotto();
        }
    }

    private Lotto getWinningLotto(){
        try {
            InputView.printRequireWinningNumbersMessage();
            return new LottoGenerator(new WinningLottoGenerateStrategy()).generateLotto();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private Bonus getBonus(){
        try {
            return Bonus.from(InputView.getBonusInput());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonus();
        }
    }

    private WinningStatistics makeStatistics(Lottos userLottos, WinningLotto winningLotto){
        return WinningStatistics.of(userLottos, winningLotto, budget);
    }
}
