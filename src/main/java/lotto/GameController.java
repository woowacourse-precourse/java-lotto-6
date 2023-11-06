package lotto;

import lotto.domain.LottoTicket;
import lotto.service.LottoMachine;
import lotto.ui.ErrorMessage;
import lotto.ui.InputView;
import lotto.ui.OutputMessage;
import lotto.ui.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {
    private final int TICKET_PRICE = 1000;
    private static final String commonErrorMessage = ErrorMessage.COMMON_MESSAGE.getMessage();
    private final InputView inputView;
    private final OutputView outputView;
    private LottoTicket lottoTicket;
    private int bonusNumber;
    private int ticketCount;
    private List<Integer> winningNumbers;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoTicket = new LottoTicket();
        this.winningNumbers = new ArrayList<>();
    }

    public void play() {
        int amount = setAmount();
        ticketCount = amount / TICKET_PRICE;
        setLottoTicket();
        outputView.displayLottoTicket(OutputMessage.DISPLAY_TICKET_COUNT, ticketCount, lottoTicket);
        setWinningNumbers();
        setBonusNumber();
    }

    private int setAmount() {
        outputView.displayMessage(OutputMessage.GET_AMOUNT_MESSAGE);
        int amount = inputView.getAmount();
        return amount;
    }

    private void setLottoTicket() {
        lottoTicket = LottoMachine.createLottoTicket(ticketCount);
    }

    private void setWinningNumbers() {
        boolean valid = false;
        outputView.displayMessage(OutputMessage.GET_WINNING_NUMBERS);

        while (!valid) {
            winningNumbers = inputView.getWinningNumbers();
            try {
                validateDuplicate(winningNumbers);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers) throws IllegalArgumentException {
        Set<Integer> checkSet = new HashSet<>(winningNumbers);
        if (checkSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_DUPLICATE_ERROR));
        }
    }

    private void setBonusNumber() {
        boolean valid = false;
        outputView.displayMessage(OutputMessage.GET_BONUS_NUMBER);
        while (!valid) {
            try {
                bonusNumber = inputView.getBonusNumber();
                validateContains(bonusNumber);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateContains(int bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_DUPLICATE_ERROR));
        }
    }

    private String createErrorMessage(ErrorMessage errorMessage) {
        return errorMessage.getMessage() + " " + commonErrorMessage;
    }
}