package lotto;

import lotto.controller.LottoController;
import lotto.domain.Bank;
import lotto.domain.LottoShop;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoShop lottoShop = new LottoShop();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(inputView, lottoShop, outputView, lottoService);
        lottoController.run();
    }
}
