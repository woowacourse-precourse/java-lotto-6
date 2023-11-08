package lotto.config;

import lotto.controller.LottoController;
import lotto.exception.InputExceptionTemplate;
import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {

    private static LottoConfig lottoConfig;

    private LottoController lottoController;
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private InputExceptionTemplate inputExceptionTemplate;

    public static LottoConfig getInstance() {
        if (lottoConfig == null) {
            lottoConfig = new LottoConfig();
        }
        return lottoConfig;
    }

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(
                    lottoService(),
                    inputView(),
                    outputView()
            );
        }
        return lottoController;
    }

    public LottoService lottoService() {
        if (lottoService == null) {
            lottoService = new LottoService(
                    inputExceptionTemplate()
            );
        }
        return lottoService;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView(
                    inputValidator()
            );
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public InputValidator inputValidator() {
        if (inputValidator == null) {
            inputValidator = new InputValidator();
        }
        return inputValidator;
    }

    public InputExceptionTemplate inputExceptionTemplate() {
        if (inputExceptionTemplate == null) {
            inputExceptionTemplate = new InputExceptionTemplate();
        }
        return inputExceptionTemplate;
    }
}
