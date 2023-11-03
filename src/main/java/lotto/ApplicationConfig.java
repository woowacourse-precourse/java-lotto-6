package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.validator.InputViewValidator;

public class ApplicationConfig {
    public LottoController lottoController(){
        return new LottoController(lottoService());
    }

    public LottoService lottoService(){
        return new LottoService(inputView(),outputView());
    }

    public InputView inputView(){
        return new InputView(inputViewValidator());
    }

    public OutputView outputView(){
        return new OutputView();
    }

    public InputViewValidator inputViewValidator(){
        return new InputViewValidator();
    }
}
