package lotto.controller;

import lotto.domain.*;
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
        Lotto winningLotto = getWinningLotto();
        outputView.displayLottoTickets(lottoCount, autoLottoTickets);
        BonusNumber bonusNumber = getBonusNumber();
        System.out.println(bonusNumber.getBonusNumber());
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

    public Lotto getWinningLotto() {
        while (true) {
            try {
                return Lotto.makeWinningNumbers(inputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public BonusNumber getBonusNumber() {
        while (true) {
            try {
                WinningNumbers winningNumbers = WinningNumbers.from(inputView.readBonusNumber());
                return new BonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
