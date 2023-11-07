package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.Profit;
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

        List<Rank> rankResult = calculateWinning(issuedLottos);
        printWinning(rankResult);

        Profit profit = calculateProfit(rankResult);
        printProfit(profit);
    }

    private IssuedLottos buyLottoTickets() {
        while(true) {
            try {
                PurchaseAmountRequest purchaseAmount = inputView.getPurchaseAmount();
                return lottoService.generateLottos(purchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.informErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottoTickets(IssuedLottos issuedLottos) {
        List<LottoResponse> lottoResponses = issuedLottos.convertToResponse();
        outputView.informIssuedLottos(lottoResponses);
    }

    private List<Rank> calculateWinning(IssuedLottos issuedLottos) {
        while(true) {
            try {
                WinningNumberRequest winningNumberRequest = inputView.getWinningNumber();
                Lotto winningLotto = winningNumberRequest.convertToValidLotto();

                BonusNumberRequest bonusNumberRequest = inputView.getBonusNumber();
                BonusNumber bonusNumber = bonusNumberRequest.convertToValidBonusNumber();

                return  lottoService.determineWinning(issuedLottos, winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.informErrorMessage(e.getMessage());
            }
        }
    }

    private void printWinning(List<Rank> ranks) {
        WinningResponse response = new WinningResponse(ranks);
        outputView.informWinningResult(response);
    }

    private Profit calculateProfit(List<Rank> ranks) {
        return lottoService.createProfit(ranks);
    }

    private void printProfit(Profit profit) {
        ProfitResponse profitResponse = profit.convertResponse();
        outputView.informProfit(profitResponse);
    }
}
