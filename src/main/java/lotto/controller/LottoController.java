package lotto.controller;

import java.util.List;
import lotto.domain.IssuedLottos;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.utility.vo.request.BonusNumberRequest;
import lotto.utility.vo.response.LottoResponse;
import lotto.utility.vo.response.ProfitResponse;
import lotto.utility.vo.request.PurchaseAmountRequest;
import lotto.utility.vo.request.WinningNumberRequest;
import lotto.utility.vo.response.WinningResponse;
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
        IssuedLottos issuedLottos = buyLottoTickets();
        printLottoTickets(issuedLottos);
        determineWinning(issuedLottos);
    }

    private IssuedLottos buyLottoTickets() {
        while(true) {
            try {
                PurchaseAmountRequest purchaseAmount = inputView.getPurchaseAmount();
                return lottoService.generateLottos(purchaseAmount);
            } catch (Exception e) {
                outputView.informErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottoTickets(IssuedLottos issuedLottos) {
        List<LottoResponse> lottoResponses = issuedLottos.convertToResponse();
        outputView.informIssuedLottos(lottoResponses);
    }

    private void determineWinning(IssuedLottos issuedLottos) {
        WinningNumberRequest winningNumberRequest = inputView.getWinningNumber();
        BonusNumberRequest bonusNumberRequest = inputView.getBonusNumber();

        List<Rank> ranks = lottoService.determineWinning(
            issuedLottos, bonusNumberRequest, winningNumberRequest);
        ProfitResponse profitResponse = lottoService.createProfit(ranks);

        outputView.informWinningResult(new WinningResponse(ranks));
        outputView.informProfit(profitResponse);
    }
}
