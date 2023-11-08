package controller;

import java.util.List;
import model.PurchasedLotto;
import view.InputView;

public class GameController {

    GameService gameService;
    List<Integer> winningNumbers;
    int bonusNumber;
    PurchasedLotto lottoVO;

    public void userPurchase() {
        int userPurchase = gameService.userPurchaseLotto();
        lottoVO = new PurchasedLotto(userPurchase);
    }

    public void setWinningNumbers() {
        winningNumbers = InputView.lottoWinningNumber();
        bonusNumber = InputView.bonusNumber();
    }

    public void gameFinish() {

    }

}
