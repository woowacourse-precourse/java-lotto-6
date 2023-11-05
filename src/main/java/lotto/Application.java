package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.RandomNumberGenerator;
import lotto.view.InputDevice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new LottoService(new RandomNumberGenerator()), new InputView(new InputDevice()), new OutputView()
        );
        lottoController.play();
    }
}
