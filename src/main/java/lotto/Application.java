package lotto;

import lotto.controller.LottoController;
import lotto.system.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final Validator VALIDATOR = new Validator();
    private static final InputView INPUT_VIEW = new InputView(VALIDATOR);
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(INPUT_VIEW, OUTPUT_VIEW);
        lottoController.gameStart();
    }
}
