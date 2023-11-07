package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Rankings;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.Lotto;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private GameService gameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void proceedGame() {
        setUp();
        receiveUserNumbers();
        decideOutcome();
    }

    private void setUp() {
        int userPurchaseAmount = inputView.readPurchaseAmount();
        this.gameService = GameService.setUpGame(userPurchaseAmount);
        outputView.printPurchaseResultMessage(userPurchaseAmount);
        outputView.printIssuedLotto(gameService.getIssuedLotto());
    }

    private void receiveUserNumbers() {
        Lotto winningTicket = getWinningTicket();
        WinningNumbers winningNumbers = askBonusNumber(winningTicket);
        gameService.storeUserInput(winningNumbers);
    }

    private void decideOutcome() {
        Map<Rankings, Integer> statistics = gameService.getStatistics();
        outputView.printWinningResult(statistics);
        String yield = gameService.getCalculatedYield();
        outputView.printYield(yield);
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

    //    private BonusNumber askBonusNumber(Lotto winningTicket) {
    private WinningNumbers askBonusNumber(Lotto winningTicket) {
        try {
            int userInputBonusNumber = inputView.readBonusNumber();
            return new WinningNumbers(winningTicket, userInputBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askBonusNumber(winningTicket);
        }
    }
}
