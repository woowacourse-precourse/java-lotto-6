package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LotteryOffice;
import lotto.domain.LottoStore;
import lotto.domain.MarginCalculator;
import lotto.domain.lotto.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void proceedGame() {
        int userPurchaseAmount = inputView.readPurchaseAmount();
        LottoStore lottoStore = new LottoStore(userPurchaseAmount);

        while (lottoStore.isOpen()) {
            lottoStore.issueLotto();
        }

        outputView.printPurchaseResultMessage(userPurchaseAmount);
        lottoStore.getIssuedLotto().forEach(this::printPurchaseResult);

        Lotto winningTicket= getWinningTicket();
        printPurchaseResult(winningTicket);
        BonusNumber bonusNumber = askBonusNumber(winningTicket);
        System.out.println(bonusNumber);
        LotteryOffice lotteryOffice = new LotteryOffice(lottoStore.getIssuedLotto(), winningTicket, bonusNumber);
        outputView.printWinningResult(lotteryOffice.getWinningsAndCounts());
        MarginCalculator marginCalculator = new MarginCalculator(lotteryOffice.getWinningsAndCounts(), userPurchaseAmount);
        System.out.println(marginCalculator.getMargin());
    }

    private Lotto getWinningTicket() {
        try {
            List<Integer> userInputWinningNumbers = inputView.readWinningNumbers();
            return new Lotto(userInputWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningTicket();
        }
    }

    private BonusNumber askBonusNumber(Lotto winningTicket) {
        try {
            int userInputBonusNumber = inputView.readBonusNumber();
            return new BonusNumber(userInputBonusNumber, winningTicket);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askBonusNumber(winningTicket);
        }
    }

    private void printPurchaseResult(Lotto lotto) {
        outputView.printLottoNumbers(lotto.getNumbers());
    }
}
