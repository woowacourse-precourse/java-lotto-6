package lotto.controller;

import java.util.List;
import lotto.domain.IssuedLottos;
import lotto.service.LottoService;
import lotto.utility.vo.LottoResponse;
import lotto.utility.vo.PurchaseAmountRequest;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        buyLottoTickets();
    }

    private IssuedLottos buyLottoTickets() {
        PurchaseAmountRequest purchaseAmount = inputView.getPurchaseAmount();
        IssuedLottos lottos = lottoService.generateLottos(purchaseAmount);

        List<LottoResponse> lottoResponses = lottos.convertToResponse();
        outputView.informIssuedLottos(lottoResponses);

        return lottos;
    }
}
