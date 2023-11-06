package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final LottoController instance = new LottoController();

    public static LottoController getInstance() {
        return instance;
    }

    private LottoController() {
    }

    private final LottoService lottoService = LottoService.getInstance();

    public void run() {
        OutputView.PrintBuyPrice();
        int buyAmount = InputView.getBuyAmount();
        OutputView.PrintBuyAmount(buyAmount);
        List<Lotto> userLottos = lottoService.getLottoNumbers(buyAmount);
    }
}
