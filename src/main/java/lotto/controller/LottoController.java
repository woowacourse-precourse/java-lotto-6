package lotto.controller;

import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private static final LottoController instance = new LottoController();

    public static LottoController getInstance() {
        return instance;
    }

    private LottoController() {
    }

    private final LottoService racingCarService = LottoService.getInstance();

    public void run() {
        OutputView.PrintBuyAmount();

    }
}
