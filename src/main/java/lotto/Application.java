package lotto;

import lotto.controller.LottoController;
import lotto.view.Output;

public class Application {

    public static void main(String[] args) {
        Output output = new Output();
        LottoController lottoController = new LottoController();
        try {
            lottoController.start();
        } catch (IllegalArgumentException e) {
            output.printError(e);
        }
    }
}