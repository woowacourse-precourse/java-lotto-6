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
        LottoService lottoService = createLottoService();

        LottoController lottoController = createController(lottoService);
        lottoController.startLotto();
    }

    private static LottoController createController(LottoService lottoService) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        InputParser inputParser = new InputParser();
        InputValidator inputValidator = new InputValidator();

        InputHandler inputHandler = new InputHandler(inputView, outputView,
                inputParser, inputValidator);

        return new LottoController(lottoService, inputHandler, outputView);
    }

    private static LottoService createLottoService() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoChecker lottoChecker = new LottoChecker();

        return new LottoService(lottoGenerator, lottoChecker);
    }
}
