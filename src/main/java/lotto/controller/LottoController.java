package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PlayerLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    PlayerLottos playerLottos;
    Lotto lotto;

    public void run() {
        int money = inputView.inputMoney();
        playerLottos = new PlayerLottos(money);

        outputView.printIssueCount(money);
        outputView.printPlayerLottos(playerLottos);

        lotto = new Lotto(inputView.inputLottoNumbers());

    }
}
