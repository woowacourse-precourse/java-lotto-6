package lotto;

import lotto.controller.LottoController;
import lotto.controller.util.handler.InputHandler;
import lotto.controller.util.parser.InputParser;
import lotto.controller.util.validator.InputValidator;
import lotto.model.service.LottoChecker;
import lotto.model.service.LottoGenerator;
import lotto.model.service.LottoService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoChecker lottoChecker = new LottoChecker();
        LottoService lottoService = new LottoService(lottoGenerator, lottoChecker);

        InputView inputView = new InputView();
        InputParser inputParser = new InputParser();
        InputValidator inputValidator = new InputValidator();
        OutputView outputView = new OutputView();
        InputHandler inputHandler = new InputHandler(inputView, outputView,
                inputParser, inputValidator);

        LottoController lottoController = new LottoController(lottoService, inputHandler, outputView);
        lottoController.startLotto();
    }
}
