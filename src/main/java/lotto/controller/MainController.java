package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.LottoService;
import lotto.model.PlayerLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    public MainController() {

    }

    public void play() {
        InputController inputController = new InputController();
        inputController.getLottomoney();
        inputController.getLottoNumber();
        inputController.getBonusNumber();

        // 당첨내역 출력


        // 수익률 출력
    }
}
