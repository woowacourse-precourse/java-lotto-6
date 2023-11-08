package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Cost;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.service.BonusNumberService;
import lotto.service.CostService;
import lotto.service.LottoNumberService;
import lotto.service.ResultService;
import lotto.service.WinningNumberService;
import lotto.view.Output;

public class GameController {

    private final CostService costService;
    private final LottoNumberService lottoNumberService;
    private final WinningNumberService winningNumberService;
    private final BonusNumberService bonusNumberService;
    private final ResultService resultService;
    private Cost cost;
    private Lottos randomLottos;
    private WinningLotto winningLotto;
    private Bonus bonus;
    private Result result;


    public GameController() {
        this.costService = new CostService();
        this.lottoNumberService = new LottoNumberService();
        this.winningNumberService = new WinningNumberService();
        this.bonusNumberService = new BonusNumberService();
        this.resultService = new ResultService();
    }

    public void start() {
        purchaseLotto();
        fetchWinningConditions();
        result = resultService.creatResult(randomLottos, bonus, winningLotto);
        printResult();

    }

    private void purchaseLotto() {
        cost = costService.fetchValidatedCost();
        randomLottos = lottoNumberService.createRandomLottos(cost);
        Output.printLottos(randomLottos);
    }

    private void fetchWinningConditions() {
        winningLotto = winningNumberService.fetchValidatedWinningNumber();
        bonus = bonusNumberService.fetchValidatedBonus(winningLotto);
    }

    private void printResult() {
        Output.resultOverView();
        Output.printMatchResult(result);
        Output.printProfit(result, cost);
    }

}
