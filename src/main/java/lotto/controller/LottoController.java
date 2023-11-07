package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    private Integer buyPrice;
    private Integer buyLottoCount;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        start();
        buy();
    }

    private void start() {
        outputView.outputStartMessage();
        buyPrice = inputView.inputPrice();
    }

    private void buy() {
        buyLottoCount = lottoService.buyLottoCount(buyPrice);
    }

}
