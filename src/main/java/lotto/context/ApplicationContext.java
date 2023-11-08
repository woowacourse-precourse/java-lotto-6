package lotto.context;

import lotto.component.LottoController;
import lotto.component.LottoValidator;
import lotto.component.LottoViewResolver;
import lotto.service.LottoMessagePrinter;
import lotto.service.LottoService;
import lotto.view.read.InputView;
import lotto.view.write.OutputView;

public class ApplicationContext {

    private InputView inputView;
    private OutputView outputView;
    private LottoMessagePrinter printer;
    private LottoValidator validator;
    private LottoController lottoController;
    private LottoService lottoService;
    private LottoViewResolver viewResolver;

    public static ApplicationContext of() {
        return new ApplicationContext();
    }

    private ApplicationContext() {
        this.inputView = inputView();
        this.outputView = outputView();
        this.printer = printer();
        this.validator = validator();
        this.lottoService = lottoService();
        this.lottoController = lottoController();
        this.viewResolver = viewResolver();
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private LottoMessagePrinter printer() {
        if (printer == null) {
            printer = LottoMessagePrinter.of(outputView());
        }
        return printer;
    }

    private LottoViewResolver viewResolver() {
        if (viewResolver == null) {
            viewResolver = LottoViewResolver.of(printer());
        }
        return viewResolver;
    }

    private LottoValidator validator() {
        if (validator == null) {
            validator = new LottoValidator();
        }
        return validator;
    }

    private LottoController lottoController() {
        if (lottoController == null) {
            lottoController = LottoController.of(lottoService());
        }
        return lottoController;
    }

    private LottoService lottoService() {
        if (lottoService == null) {
            lottoService = LottoService.of();
        }
        return lottoService;
    }

    public InputView getInputView() {
        return inputView;
    }

    public LottoViewResolver getViewResolver() {
        return viewResolver;
    }

    public LottoMessagePrinter getPrinter() {
        return printer;
    }

    public LottoValidator getValidator() {
        return validator;
    }

    public LottoController getLottoController() {
        return lottoController;
    }
}
