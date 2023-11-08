package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottery;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.NumberGenerator;
import lotto.domain.Profit;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.handler.InputHandler;
import lotto.view.OutputView;

public class LottoController {
    private NumberGenerator lottoNumberGenerator;

    public LottoController(NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        Lottery lottery = prepareLottery();
        startLottery(lottery);
    }

    private Lottery prepareLottery() {
        OutputView.printPurchaseInputText();
        PurchasePrice purchasePrice = InputHandler.receiveValidatedPurchasePrice();
        LottoTicket lottoTicket = createLottoEqualTo(purchasePrice);
        OutputView.printWinningNumberInputText();
        WinningNumber winningNumber = InputHandler.receiveValidatedWinningNumber();
        OutputView.printBonusNumberInputText();
        BonusNumber bonusNumber = InputHandler.receiveValidatedBonusNumberAndNotExistFrom(winningNumber);
        return new Lottery(winningNumber, bonusNumber, lottoTicket);
    }

    private LottoTicket createLottoEqualTo(PurchasePrice purchasePrice) {
        LottoTicket lottoTicket = LottoTicket.of(purchasePrice, lottoNumberGenerator);
        OutputView.printPurchasedCount(lottoTicket);
        OutputView.printPurchasedLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private void startLottery(Lottery lottery) {
        LottoResult lottoResult = lottery.createLottoResult();
        OutputView.printWinningResult(lottoResult);
        OutputView.printRateOfReturn(new Profit(lottoResult));
    }
}