package controller;

import java.util.List;
import model.LottoVO;
import view.InputView;

public class GameController {

    GameService gameService;
    List<Integer> winningNumbers;
    int bonusNumber;
    LottoVO lottoVO;

    public void userPurchase() {
        int userPurchase = gameService.userPurchaseLotto();
        lottoVO = new LottoVO(userPurchase);
    }

    public void setWinningNumbers() {
        winningNumbers = InputView.lottoWinningNumber();
        bonusNumber = InputView.bonusNumber();
    }

    public void gameFinish() {

    }

}
