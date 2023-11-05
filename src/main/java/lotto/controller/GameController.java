package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    public void init() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoCount lottoCount = LottoCount.from(purchaseAmount);
        List<Lotto> autoLottoTickets = Lotto.getAutoLottoTickets(lottoCount);
        outputView.displayLottoTickets(lottoCount, autoLottoTickets);
        Lotto winningNumbers = getWinningNumbers();
    }

    public PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmount.from(inputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public Lotto getWinningNumbers() {
        while (true) {
            try {
                return Lotto.makeWinningNumbers(inputView.readWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
