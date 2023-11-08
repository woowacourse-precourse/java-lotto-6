package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Statistics;
import lotto.ui.OutputView;

import java.util.List;

public class LottoController {
    private int lottoAmount;
    private int lottoCost;
    private int bonusNumber;
    private List<Lotto> myLotto;
    private List<Integer> prizeNumbers;
    private List<Integer> prizeCount;
    private float profitPercent;

    public void startGame() {
        setMyLotto();
        printMyLotto();
        setPrizeLotto();
        setResult();
        printResult();
    }

    private void setMyLotto() {
        InputController inputController = new InputController();
        inputController.setAmount();
        lottoAmount = inputController.getAmount();
        lottoCost = inputController.getCost();
        LottoGenerator lottogenerator = new LottoGenerator(lottoAmount);
        myLotto = lottogenerator.getMyLotto();
    }

    private void setPrizeLotto() {
        InputController inputController = new InputController();
        inputController.setPrizeNumbers();
        inputController.setBonusNumber();
        this.prizeNumbers = inputController.getPrizeNumbers();
        this.bonusNumber = inputController.getBonusNumber();
    }

    private void setResult() {
        Statistics statistics = new Statistics(myLotto, prizeNumbers, bonusNumber, lottoCost);
        this.prizeCount = statistics.getPrizesCount();
        this.profitPercent = statistics.getProfitPercent();
    }

    private void printMyLotto() {
        OutputView.printLotto(myLotto);
    }

    private void printResult() {
        OutputView.printStatistics(prizeCount, profitPercent);
    }
}
