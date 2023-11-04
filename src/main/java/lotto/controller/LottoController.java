package lotto.controller;

import lotto.model.PlayerLottos;
import lotto.view.InputView;

public class LottoController {
    InputView inputView = new InputView();
    PlayerLottos playerLottos;

    public void run() {
        int money = inputView.inputMoney();
        playerLottos = new PlayerLottos(money);
    }
}
