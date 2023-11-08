package lotto;

import lotto.view.LottoView;
import lotto.controller.LottoController;
import lotto.model.InputValidator;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        LottoView lottoView = new LottoView(inputValidator);

        LottoController controller = new LottoController(lottoView);

        controller.run();
    }
}