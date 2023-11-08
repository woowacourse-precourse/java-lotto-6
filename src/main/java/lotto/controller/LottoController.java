package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.Profit;
import lotto.domain.LottoTicketMachine;
import lotto.domain.WinningRanks;
import lotto.utility.validation.WinningNumberChecker;
import lotto.vo.request.BonusNumberRequest;
import lotto.vo.response.LottoResponse;
import lotto.vo.response.ProfitResponse;
import lotto.vo.request.PurchaseAmountRequest;
import lotto.vo.request.WinningNumberRequest;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        IssuedLottos issuedLottos = buyLottoTickets();
        printLottoTickets(issuedLottos);

        WinningRanks rankResult = calculateWinning(issuedLottos);
        printWinning(rankResult);

        Profit profit = calculateProfit(rankResult);
        printProfit(profit);
    }

    private IssuedLottos buyLottoTickets() {
        while(true) {
            try {
                PurchaseAmountRequest purchaseAmount = inputView.getPurchaseAmount();
                return LottoTicketMachine.generateLottos(purchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.informErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottoTickets(IssuedLottos issuedLottos) {
        List<LottoResponse> lottoResponses = issuedLottos.convertToResponse();
        outputView.informIssuedLottos(lottoResponses);
    }

    private WinningRanks calculateWinning(IssuedLottos issuedLottos) {
        while(true) {
            try {
                WinningNumberRequest winningNumberRequest = inputView.getWinningNumber();
                Lotto winningLotto = winningNumberRequest.convertToValidLotto();

                BonusNumberRequest bonusNumberRequest = inputView.getBonusNumber();
                BonusNumber bonusNumber = bonusNumberRequest.convertToValidBonusNumber();

                WinningNumberChecker.validate(winningLotto, bonusNumber);
                return  issuedLottos.determineRanks(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.informErrorMessage(e.getMessage());
            }
        }
    }

    private void printWinning(WinningRanks ranks) {
        outputView.informWinningResult(ranks.convertToResponse());
    }

    private Profit calculateProfit(WinningRanks ranks) {
        return ranks.determineProfit();
    }

    private void printProfit(Profit profit) {
        ProfitResponse profitResponse = profit.convertResponse();
        outputView.informProfit(profitResponse);
    }
}
