package lotto.domain;

import lotto.Lotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class LottoController {
    private int lottoAmount;
    private int bonusNumber;
    private List<Lotto> myLotto;
    private List<Integer> prizeNumbers;

    public void startGame() {
        setMyLotto();
        printMyLotto();
        setPrizeLotto();
        setLottoResult();
        printLottoResult();
    }

    private void setMyLotto() {
        UserInput userInput = new UserInput();
        InputView.readCost();
        userInput.setAmount();
        lottoAmount = userInput.getAmount();
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
}
