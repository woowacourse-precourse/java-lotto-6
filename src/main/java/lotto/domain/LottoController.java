package lotto.domain;

import lotto.Lotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class LottoController {
    private int lottoAmount;
    private int lottoCost;
    private int bonusNumber;
    private List<Lotto> myLotto;
    private List<Integer> prizeNumbers;
    private List<Integer> prizes;
    private float profitPercent;

    public void startGame() {
        setMyLotto();
        printMyLotto();
        setPrizeLotto();
        setResult();
        printResult();
    }

    private void setMyLotto() {
        UserInput userInput = new UserInput();
        InputView.readCost();
        userInput.setAmount();
        lottoAmount = userInput.getAmount();
        lottoCost = userInput.getCost();
        LottoGenerator lottogenerator = new LottoGenerator(lottoAmount);
        myLotto = lottogenerator.getMyLotto();
    }

    private void printMyLotto() {
        OutputView.printLotto(myLotto);
    }

    private void setPrizeLotto() {
        UserInput userInput = new UserInput();
        InputView.readNumbers();
        userInput.setPrizeNumbers();
        InputView.readBonusNumber();
        userInput.setBonusNumber();
        this.prizeNumbers = userInput.getPrizeNumbers();
        this.bonusNumber = userInput.getBonusNumber();
    }

    private void setResult() {
        Statistics statistics = new Statistics(myLotto, prizeNumbers, bonusNumber, lottoCost);
        this.prizes = statistics.getPrizes();
        this.profitPercent = statistics.getProfitPercent();
    }

    private void printResult() {
        OutputView.printStatistics(prizes, profitPercent);// parameter calculated something
    }
}
