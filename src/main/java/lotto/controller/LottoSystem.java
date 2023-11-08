package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.service.*;
import lotto.view.*;

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
        inputBudgetSystem();
        createLottosSystem();
        displayLottosSystem();
        createWinningCombinationSystem();
        Console.close();
    }

    private void ResultSystem(){
        Map<String, Integer> statisticsMatchesCounts= createStatisticsSystem();
        float profitPercent = createProfitSystem(statisticsMatchesCounts);
        outputView.displayResult(statisticsMatchesCounts,profitPercent);
    }

    private void inputBudgetSystem(){
        budget = new Budget(inputView.InputBudget());
    }

    private void createLottosSystem(){
        LottosGenerator lottosGenerator = new LottosGenerator();
        lottos = lottosGenerator.generateLottos(budget.getBudget());
    }

    private void displayLottosSystem(){
        inputView.displayLottos(lottos.getSize(),lottos.getLottosForDisplay());

    }

    private void createWinningCombinationSystem(){
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.InputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(inputView.InputBonusNumber()));
        winningCombination = new WinningCombination(winningLottoNumbers,bonusNumber);

    }

    private Map<String, Integer> createStatisticsSystem(){
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        return statisticsGenerator.generateMatchesCount();
    }

    private float createProfitSystem(Map<String, Integer> statisticsMatchesCounts){
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculateProfit(budget.getBudget(),statisticsMatchesCounts);
    }

}
