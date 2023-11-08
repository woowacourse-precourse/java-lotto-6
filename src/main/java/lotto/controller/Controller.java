package lotto.controller;

import lotto.domain.*;
import lotto.domain.lotto.*;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = buyTicket(purchaseAmount.getPurchaseCount());
        printPurchaseLottoResult(lottoTicket);

        WinningLotto winningLotto = new WinningLotto(getWinningLotto());
        getBonusNumber(winningLotto);

        WinningResult winningResult = getWinningResult(lottoTicket, winningLotto);
        printWinningResult(winningResult);


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

    private void printPurchaseLottoResult(LottoTicket ticket) {
        OutputView.printPurchaseLottoResult(ticket);
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

    private void printWinningResult(WinningResult winningResult) {
        OutputView.printWinningResult(winningResult);
    }

}


