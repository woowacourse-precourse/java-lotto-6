package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.play();

    }
}
