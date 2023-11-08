package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final TicketVendingMachine ticketVendingMachine;
    private PrizeCalculator prizeCalculator;
    private LottoDrawMachine lottoDrawMachine;

    public LottoGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        ticketVendingMachine = new TicketVendingMachine();
        startGame();
    }

    private void startGame() {
        int purchaseAmount = requestPurchaseAmount();
        LottoTicket lottoTicket = purchaseLottoTicket(purchaseAmount);
        Lotto winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber();
        setupLottoDrawMachine(winningNumbers, bonusNumber);
        calculateAndPresentResults(lottoTicket, purchaseAmount);
    }

    private int requestPurchaseAmount() {
        outputView.getAmount();
        int amount = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                amount = inputView.purchaseAmount();
                validInput = true;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
        return amount;
    }

    private LottoTicket purchaseLottoTicket(int initialAmount) {
        int amount = initialAmount;
        LottoTicket lottoTicket = null;
        while (lottoTicket == null) {
            try {
                lottoTicket = ticketVendingMachine.buyTicket(amount);
                lottoTicket.printLottoTickets(outputView);
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
                amount = requestPurchaseAmount();
            }
        }
        return lottoTicket;
    }

    private Lotto requestWinningNumbers() {
        outputView.getWinningNumbers();
        List<Integer> numbers = null;
        while (numbers == null) {
            try {
                numbers = inputView.winningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
        return new Lotto(numbers);
    }

    private int requestBonusNumber() {
        outputView.getBonusNumber();
        Integer bonusNumber = null;
        while (bonusNumber == null) {
            try {
                bonusNumber = inputView.bonusNumber();
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private void setupLottoDrawMachine(Lotto winningNumbers, int bonusNumber) {
        while (true) {
            try {
                lottoDrawMachine = new LottoDrawMachine(winningNumbers, bonusNumber);
                prizeCalculator = new PrizeCalculator(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
                bonusNumber = requestBonusNumber();
            }
        }
    }

    private void calculateAndPresentResults(LottoTicket lottoTicket, int purchaseAmount) {
        LottoResult result = prizeCalculator.calculateLottoResult(lottoTicket, purchaseAmount);
        outputView.prizeResult(result.getPrizeResults(), result.getEarnRate());
    }
}
