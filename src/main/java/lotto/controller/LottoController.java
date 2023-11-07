package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        PurchaseAmount purchaseAmount = readAmount();

        LottoTicket lottoTicket = buyTicket(purchaseAmount);

        LuckyNumbers luckyNumbers = createLuckyNumber();
    }

    private PurchaseAmount readAmount() {
        try {
            return new PurchaseAmount(InputView.readPurchaseAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readAmount();
        }
    }

    private LottoTicket buyTicket(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculateLottoCount();
        OutputView.printLottoCount(lottoCount);

        LottoTicket lottoTicket = new LottoTicket(lottoCount);
        OutputView.printTicket(lottoTicket);
        return lottoTicket;
    }

    private LuckyNumbers createLuckyNumber(){
        Lotto winningNumber = readWinningNumbers();
        LottoNumber bonusNumber = readBonusNumber();

        return getLuckyNumbers(winningNumber, bonusNumber);
    }

    private Lotto readWinningNumbers() {
        try {
            return new Lotto(InputView.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readWinningNumbers();
        }
    }

    private LottoNumber  readBonusNumber() {
        try {
            return new LottoNumber(InputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readBonusNumber();
        }
    }

    private LuckyNumbers getLuckyNumbers(Lotto winningNumbers, LottoNumber bonusNumber){
        try {
            return new LuckyNumbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getLuckyNumbers(winningNumbers, readBonusNumber());
        }

    }

}
