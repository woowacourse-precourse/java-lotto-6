package lotto;

import lotto.controller.LottoController;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        LottoController controller = new LottoController(inputView, outputView);

        controller.run();
    }
}
