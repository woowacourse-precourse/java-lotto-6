package controller;

import lotto.LottoMoney;
import view.InputView;

public class GameController {
    LottoMoney lottoMoney;

    InputView inputView = new InputView();
    boolean restart = true;

    public void startGame() {
        saveLottoMoney();
    }

    private void saveLottoMoney() {
        while (restart) {
            try {
                String inputMoney = inputView.enterLottoMoney();
                lottoMoney = new LottoMoney(inputMoney);
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
