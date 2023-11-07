package lotto.controller;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;

public class Controller {
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
        lottos.makeLottoGame();
    }

    public void showHowmanyLottosBuy(){
        lottos.howManyLottos();
    }

    public void putWinningNumber(){
        InputView.requestWinningNumbers();
        winningNumbers.generateWinningNumbers();

    }
}