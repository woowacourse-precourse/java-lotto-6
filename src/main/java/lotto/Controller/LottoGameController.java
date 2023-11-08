package lotto.Controller;

import lotto.Model.*;
import lotto.View.LottoView;

import java.util.*;

public class LottoGameController {
    public LottoView view;
    private LottoTicket ticket;
    private WinningNumbers winningNumbers;

    public LottoGameController(LottoView view) {
        this.view = view;
    }

    public void playLottoGame() {
        boolean continueGame = true;
        while (continueGame) {
            try {
                int purchaseAmount = getPurchaseAmountFromUser();
                createLottoTicketAndWinningNumbers(purchaseAmount);
                Map<Integer, Integer> statistics = calculateWinningStatistics(ticket, winningNumbers);
                double profitRate = calculateProfitRate(purchaseAmount, statistics);
                displayLottoResults(statistics, profitRate);
                continueGame = false; // 정상 처리되면 루프를 빠져나옴
            } catch (IllegalArgumentException e) {
                view.displayError(e.getMessage()); // 사용자에게 다시 입력을 받기 위해 루프를 계속함
            }
        }
    }

    private int getPurchaseAmountFromUser() {
        UserInput userInput = new UserInput();
        return userInput.getPurchaseAmountFromInput(view);
    }

    private void createLottoTicketAndWinningNumbers(int purchaseAmount) {
        this.ticket = new LottoTicket(purchaseAmount / 1000);
        this.winningNumbers = new UserInput().getWinningNumbersFromInput(view);
    }

    private Map<Integer, Integer> calculateWinningStatistics(LottoTicket ticket, WinningNumbers winningNumbers){
        LottoGameCalculator lottoGameCalculator = new LottoGameCalculator();
        return lottoGameCalculator.calculateWinningStatistics(ticket, winningNumbers);
    }

    private double calculateProfitRate(int purchaseAmount, Map<Integer, Integer> statistics){
        LottoGameCalculator lottoGameCalculator = new LottoGameCalculator();
        return lottoGameCalculator.calculateProfitRate(purchaseAmount, statistics);
    }

    private void displayLottoResults(Map<Integer, Integer> statistics, double profitRate) {
        view.displayLottoNumbers(ticket.getLottos());
        view.displayWinningStatistics(statistics, profitRate);
    }

}
