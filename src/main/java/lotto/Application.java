package lotto;

import lotto.controller.LottoController;
import lotto.controller.util.parser.InputParser;
import lotto.controller.util.validator.InputValidator;
import lotto.model.LottoService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputParser inputParser = new InputParser();
        InputValidator inputValidator = new InputValidator();
        LottoController lottoController = new LottoController(lottoService, inputView, outputView, inputParser,
                inputValidator);

        lottoController.startLotto();
    }
}
