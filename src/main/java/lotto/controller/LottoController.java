package lotto.controller;

import lotto.model.PlayerLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    PlayerLottos playerLottos;

    public void run() {
        int money = inputView.inputMoney();
        playerLottos = new PlayerLottos(money);

        outputView.printIssueCount(money);
        outputView.printPlayerLottos(playerLottos);

    }
}
