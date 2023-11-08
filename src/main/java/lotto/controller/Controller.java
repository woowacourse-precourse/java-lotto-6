package lotto.controller;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;

import java.util.List;

public class Controller {
    List<Integer> winnings;
    Lottos lottos = new Lottos();
    WinningNumbers winningNumbers = new WinningNumbers();

    public void lottoGame() {
//        buyLottos();
//        showHowmanyLottosBuy();
        putWinningNumber();
//        checkWinningList()
//        calculateRate();
    }

    public void buyLottos() {
        InputView.requestPurchaseAmount();
        lottos.payForLottoGame();
    }

    public void showHowmanyLottosBuy(){
        lottos.howManyLottos();
    }

    public void putWinningNumber(){
        InputView.requestWinningNumbers();
        winningNumbers.askCommonWinningNumbers();

        InputView.requestBonusNumber();
        winningNumbers.askBonusNumber();

        winnings = winningNumbers.getWinningNumbers();
    }
}