package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoSystem {
    private final InputView inputView;
    private final OutputView outputView;
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
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(inputView.InputBonusNumber()));
        winningCombination = new WinningCombination(winningLottoNumbers,bonusNumber);

        Console.close();
    }

    private void ResultSystem(){
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //lottos와 winningCombination을 통해 통계
        Map<String, Integer> statisticsMatchesCounts = statisticsGenerator.generateMatchesCount();

        //budget과 winningmoney를 통해 수익률 계산
        float profitPercent = profitCalculator.calculateProfit(budget.getBudget(),statisticsMatchesCounts);

        outputView.displayResult(statisticsMatchesCounts,profitPercent);
    }

}
