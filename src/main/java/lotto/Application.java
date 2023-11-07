package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();

        LottoController lottoController = new LottoController(lottoInput, lottoOutput);
        lottoController.run();


    }
}
