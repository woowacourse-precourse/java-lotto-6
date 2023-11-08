package lotto.controller;

import lotto.domain.dto.LottoTicketDto;
import lotto.domain.dto.WinningResultDto;
import lotto.domain.lotto.*;
import lotto.domain.result.WinningLotto;
import lotto.domain.result.WinningResult;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = buyTicket(purchaseAmount.getPurchaseCount());
        printPurchaseLottoResult(LottoTicketDto.of(lottoTicket));

        WinningLotto winningLotto = new WinningLotto(getWinningLotto());
        getBonusNumber(winningLotto);

        WinningResult winningResult = getWinningResult(lottoTicket, winningLotto);
        printWinningResult(WinningResultDto.of(winningResult));
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            return PurchaseAmount.of(Parser.parseToInt(InputView.getPurchaseAmountInput()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private LottoTicket buyTicket(int purchaseLottoCount) {
        return LottoTicketFactory.generateTicket(purchaseLottoCount);
    }

    private void printPurchaseLottoResult(LottoTicketDto lottoTicketDto) {
        OutputView.printPurchaseLottoResult(lottoTicketDto);
    }

    private Lotto getWinningLotto() {
        try {
            return new Lotto(Parser.parseToIntegers(InputView.getWinningNumbersInput()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningLotto();
        }
    }

    private void getBonusNumber(WinningLotto winningLotto) {
        try {
            winningLotto.saveBonusNumber(LottoNumber.of(Parser.parseToInt(InputView.getBonusNumbersInput())));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getBonusNumber(winningLotto);
        }
    }

    private WinningResult getWinningResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return WinningResult.from(lottoTicket, winningLotto);
    }

    private void printWinningResult(WinningResultDto winningResultDto) {
        OutputView.printWinningResult(winningResultDto);
    }

}


