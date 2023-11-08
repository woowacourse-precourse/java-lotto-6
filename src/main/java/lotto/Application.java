package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
