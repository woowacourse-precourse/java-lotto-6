package lotto;

import lotto.controller.LottoController;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutputView outputView = new ConsoleOutputView();
        final LottoNumberGenerator lottoNumberGenerator = new RandomNumberGenerator();
        final LottoController lottoController = new LottoController(inputView, outputView, lottoNumberGenerator);

        lottoController.run();
    }
}
