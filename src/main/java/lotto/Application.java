package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView());
        lottoController.launch();
    }
}
