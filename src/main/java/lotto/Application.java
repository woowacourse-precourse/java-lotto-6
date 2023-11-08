package lotto;

import lotto.controller.LottoController;
import lotto.io.Input;
import lotto.io.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        LottoController lottoController = new LottoController(input, output);
        lottoController.start();
    }
}