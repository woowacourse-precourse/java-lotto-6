package lotto.controller;

import java.util.List;
import lotto.model.PlayerLottoAmount;
import lotto.view.InputView;

public class InputController {
    public static int inputPlayerAmount() {
        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount(InputView.lottoMoneyInput());
        return playerLottoAmount.calculateLottoCount();
    }

    public static List<Integer> inputWinningNumbers() {
        return InputView.inputLottoWinningNum();
    }
}
