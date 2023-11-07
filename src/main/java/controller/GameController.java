package controller;

import view.InputView;

public class GameController {
    InputView inputView = new InputView();

    public void startGame() {
        String lottoMoney = inputView.enterLottoMoney();
        System.out.println(lottoMoney);
    }

}
