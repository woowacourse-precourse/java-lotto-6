package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoMachine;
import lotto.service.LottoResultAnalyze;
import lotto.ui.ErrorMessage;
import lotto.ui.InputView;
import lotto.ui.OutputMessage;
import lotto.ui.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameController {
    private static final int TICKET_PRICE = 1000;
    private List<Lotto> lottoTicket;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        int amount = initGame();
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);
        LottoResultAnalyze lottoResultAnalyze = new LottoResultAnalyze();
        Map<String, Integer> lottoResult = lottoResultAnalyze.calculateResult(lottoTicket, winningNumbers, bonusNumber);
        String profit = calculateProfit(amount, lottoResult);
        displayResult(lottoResult, profit);
    }

    private int initGame() {
        int amount = setAmount();
        int ticketCount = amount / TICKET_PRICE;
        setLottoTicket(ticketCount);
        displayTicketInfo(amount);
        return amount;
    }

    private int setAmount() {
        outputView.displayMessage(OutputMessage.GET_AMOUNT_MESSAGE);
        int amount = inputView.getAmount();
        return amount;
    }

    private void setLottoTicket(int ticketCount) {
        lottoTicket = LottoMachine.createLottoTicket(ticketCount);
    }

    private void displayTicketInfo(int amount) {
        int ticketCount = amount / TICKET_PRICE;
        outputView.displayLottoTicket(OutputMessage.DISPLAY_TICKET_COUNT, ticketCount, lottoTicket);
    }

    private List<Integer> setWinningNumbers() {
        boolean isValid = false;
        List<Integer> winningNumbers = new ArrayList<>();
        outputView.displayMessage(OutputMessage.GET_WINNING_NUMBERS);

        while (!isValid) {
            winningNumbers = inputView.getWinningNumbers();
            try {
                validateDuplicate(winningNumbers);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private void validateDuplicate(List<Integer> winningNumbers) throws IllegalArgumentException {
        Set<Integer> checkSet = new HashSet<>(winningNumbers);
        if (checkSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_DUPLICATE_ERROR));
        }
    }

    private int setBonusNumber(List<Integer> winningNumbers) {
        boolean isValid = false;
        int bonusNumber = 0;
        outputView.displayMessage(OutputMessage.GET_BONUS_NUMBER);
        while (!isValid) {
            try {
                bonusNumber = inputView.getBonusNumber();
                validateContains(bonusNumber, winningNumbers);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private void validateContains(int bonusNumber, List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_DUPLICATE_ERROR));
        }
    }

    private String createErrorMessage(ErrorMessage errorMessage) {
        String commonErrorMessage = ErrorMessage.COMMON_MESSAGE.getMessage();
        return errorMessage.getMessage() + " " + commonErrorMessage;
    }

    private String calculateProfit(int amount, Map<String, Integer> lottoResult) {
        long totalPrize = 0;
        for (Map.Entry<String, Integer> entry : lottoResult.entrySet()) {
            String rankName = entry.getKey();
            int count = entry.getValue();
            long prize = LottoRank.getPrizeByRank(rankName);
            totalPrize += count * prize;
        }
        double profit = ((double) totalPrize / amount) * 100;
        return String.format("%,.1f", profit);
    }

    private void displayResult(Map<String, Integer> lottoResult, String profit) {
        outputView.displayResult(OutputMessage.DISPLAY_LOTTO_RESULT, lottoResult, profit);
    }
}