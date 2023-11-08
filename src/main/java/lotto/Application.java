package lotto;

import lotto.controller.LottoController;
import lotto.view.InputViewImpl;
import lotto.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.of(new InputViewImpl(), new OutputViewImpl());
        lottoController.lottoStore();
        lottoController.answerNumbersInput();
        lottoController.printWinning();
    }
}
