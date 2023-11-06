package lotto.domain;

import lotto.Lotto;
import lotto.ui.OutputView;

import java.util.List;

public class LottoController {
    private int lottoAmount;
    private List<Lotto> myLotto;
    private List<Integer> prizeLotto;

    public void startGame() {
        setMyLotto();
        printMyLotto();
        // 당첨 통계 출력
    }

    private void setMyLotto() {
        UserInput userInput = new UserInput();
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
        userInput.setPrizeLotto();
        prizeLotto = userInput.getPrizeLotto();
    }
}
