package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.OutputService;

public class Controller {
    private final InputService inputService = new InputService();
    private final LottoService lottoService = new LottoService();
    private final OutputService outputService = new OutputService();
    private Buyer buyer;
    private Lottos lottos;

    public void run() {
        buyer = inputService.inputPurchaseAmount();
        lottos = lottoService.issueLottos(buyer);
        outputService.printLottos(lottos, buyer);
    }
}
