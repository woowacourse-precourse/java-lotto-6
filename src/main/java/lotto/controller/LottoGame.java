package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame implements Game {

    private LottoPurchase lottoPurchase;
    private LottoTickets lottoTickets;
    private WinningLotto winningLotto;


    @Override
    public void run() {
        collectPurchaseAmount();
        generateLottoTickets();
        collectWinningNumbers();
    }

    private void collectPurchaseAmount() {
        try {
            lottoPurchase = new LottoPurchase(InputView.lottoPurchaseAmountInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            collectPurchaseAmount();
        }
    }

    private void generateLottoTickets() {
        lottoTickets = lottoPurchase.generateLottoTickets();
        printLottoTickets();
    }

    private void printLottoTickets() {
        OutputView.printPurchasedLottoNumbers(lottoTickets.getLottoTickets());
    }

    private void collectWinningNumbers() {
        winningLotto = new WinningLotto(getWinningNumbers(), getBonusWinningNumber());
    }

    private Lotto getWinningNumbers() {
        return new Lotto(InputView.winningLottoNumbersInput());
    }

    private String getBonusWinningNumber() {
        return InputView.winningLottoBonusNumberInput();
    }
}

