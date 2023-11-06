package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoMachine, lottoView);

        lottoController.play();
    }
}
