package lotto;

import lotto.controller.LottoController;
import lotto.domain.entity.LottoGenerator;
import lotto.service.LottoService;
import lotto.view.input.LottoInputView;
import lotto.view.output.LottoOutputView;

public class AppConfig {

    public static LottoController setup() {
        return getLottoController();
    }

    private static LottoController getLottoController() {
        return new LottoController(
                getLottoService(),
                getLottoOutputView(),
                getLottoInputView()
        );
    }

    private static LottoService getLottoService() {
        return new LottoService(
                getLottoGenerator()
        );
    }

    private static LottoGenerator getLottoGenerator() {
        return new LottoGenerator();
    }

    private static LottoOutputView getLottoOutputView() {
        return new LottoOutputView();
    }

    private static LottoInputView getLottoInputView() {
        return new LottoInputView();
    }

}
