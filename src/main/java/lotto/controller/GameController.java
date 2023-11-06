package lotto.controller;

import java.util.List;
import lotto.domain.LottoStore;
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

    private void printPurchaseResult(Lotto lotto) {
        outputView.printLottoNumbers(lotto.getNumbers());
    }
}
