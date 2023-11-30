package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.WinningRepository;
import lotto.service.LottoService;
import lotto.service.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = getLottoController();
        lottoController.run();
    }

    private static LottoController getLottoController() {
        LottoRepository lottoRepository = new LottoRepository();
        WinningRepository winningRepository = new WinningRepository();
        Validation validation = new Validation();
        LottoService lottoService = new LottoService(lottoRepository, winningRepository, validation);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        return lottoController;
    }
}
