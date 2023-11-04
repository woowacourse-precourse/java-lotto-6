package lotto.global.config;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class AppConfig {

    public static LottoController getLottoController() {
        return new LottoController(getLottoInputView(), getLottoOutputView(), getLottoService());
    }

    private static LottoService getLottoService() {
        return new LottoService(getLottoRepository());
    }

    private static LottoRepository getLottoRepository() {
        return new LottoRepository();
    }

    private static LottoOutputView getLottoOutputView() {
        return new LottoOutputView();
    }

    private static LottoInputView getLottoInputView() {
        return new LottoInputView();
    }

}
