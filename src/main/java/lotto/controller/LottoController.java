package lotto.controller;

import lotto.domain.*;
import lotto.service.BudgetService;
import lotto.service.LottoService;
import lotto.service.WinningNumberService;
import lotto.service.WinningService;
import lotto.view.GameView;

public class LottoController {
    private final BudgetService budgetService;
    private final LottoService lottoService;
    private final WinningNumberService winningNumberService;
    private final WinningService winningService;
    private final GameView gameView;

    public LottoController() {
        budgetService = new BudgetService();
        lottoService = new LottoService();
        winningNumberService = new WinningNumberService();
        winningService = new WinningService();

        gameView = new GameView();
    }

    public void start() {
        gameView.printInputBudgetMessage();
        Budget budget = budgetService.createBudget();

        //todo: view에서 프린트하는 과정에 책임을 더 주는 건 어떨까? -> 현재에는 단순 출력만 하도록 하는데 역할을 더 줘서 처리를 하게 하는 건 어떨까
        Lottos lottos = lottoService.createLottos(budget);
        int lottosSize = lottoService.getLottosSize(lottos);
        gameView.printLottosSize(lottosSize);

        String lottosNumbers = lottoService.getLottosNumbers(lottos);
        gameView.printLottosNumbers(lottosNumbers);

        gameView.printInputWinningNumbersMessage();
        WinningNumbers winningNumbers = winningNumberService.createWinningNumbers();

        gameView.printInputBonusNumberMessage();
        WinningNumber bonusNumber = winningNumberService.createBonusNumber();

        //todo: 이 클래스의 존재가 올바른지?
        WinningManager winningManager = new WinningManager(winningNumbers, bonusNumber);

        WinningScores winningScores = winningService.calWinningScores(lottos, winningManager);
        gameView.printWinningStatistic(winningScores.toString());
    }
}
