package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoSystem {
    private InputView inputView;
    private OutputView outputView;
    private Lottos lottos;
    private WinningCombination winningCombination;
    private Budget budget;

    public LottoSystem(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void runSystem() {
        settingSystem();
        ResultSystem();
    }

    private void settingSystem(){
        budget = new Budget(inputView.InputBudget());

        LottosGenerator lottosGenerator = new LottosGenerator();
        lottos = lottosGenerator.generateLottos(budget.getBudget());

        inputView.displayLottos(lottos.getSize(),lottos.getLottosForDisplay());

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.InputWinningNumbers());
        winningCombination = new WinningCombination(winningLottoNumbers,Integer.parseInt(inputView.InputBonusNumber()));
    }

    private void ResultSystem(){
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator();
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //lottos와 winningCombination을 통해 통계
        Map<String, Integer> statisticsMatchesCounts = statisticsGenerator.generateMatchesCount(lottos,winningCombination);

        //budget과 winningmoney를 통해 수익률 계산
        float profitPercent = profitCalculator.calculateProfit(budget.getBudget(),statisticsMatchesCounts);

        outputView.displayResult(statisticsMatchesCounts,profitPercent);
    }

}
