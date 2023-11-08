package lotto.controller;

import lotto.model.*;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private static final String DELIMITER_FOR_INPUT = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private DrawNumbers drawNumbers;
    private Buyer buyer;
    private WinningResult winningResult;
    private Reward reward;
    private ProfitRate profitRate;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        setBudget();
        buyLotto();
        outputView.printLottoPurchases(buyer.getLottos());

        setWinningNumbers();
        aggregateDrawResult();
        calculateReward();
        calculateProfitRate();
        outputView.printDrawStatistics(winningResult.getWinningResult(), profitRate.getProfitRate());
    }

    private void setBudget() {
        while (true) {
            try {
                Integer budget = Converter.stringToInt(inputView.ask(inputView.budget()));
                buyer = new Buyer(budget);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void buyLotto() {
        LottoStore lottoStore = new LottoStore();
        buyer.countLottoNum();
        List<Lotto> lottos = lottoStore.sell(buyer.getLottoCount());
        buyer.setLottos(lottos);
    }

    private void setWinningNumbers() {
        while (true) {
            try {
                List<Integer> mainNumbers = Converter.stringToIntList(inputView.ask(inputView.mainNumbers()), DELIMITER_FOR_INPUT);
                List<Integer> bonusNumber = Converter.stringToIntList(inputView.ask(inputView.bonusNumber()), DELIMITER_FOR_INPUT);
                drawNumbers = new DrawNumbers(mainNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void aggregateDrawResult() {
        Aggregator aggregator = new Aggregator(drawNumbers);
        winningResult = new WinningResult();
        winningResult.calculate(aggregator.matchResult(buyer.getLottos()));
    }

    private void calculateReward() {
        reward = new Reward();
        reward.calculate(winningResult.getWinningResult());
    }

    private void calculateProfitRate() {
        profitRate = new ProfitRate();
        profitRate.calculate(reward.getReward(), buyer.getBudget());
    }
}
