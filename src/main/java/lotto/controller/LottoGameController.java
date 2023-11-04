package lotto.controller;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_CONTAINS_WINNING_ERROR_MESSAGE;

import java.util.List;
import lotto.Lotto;
import lotto.util.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.BonusNumber;
import lotto.vo.TicketQuantity;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        TicketQuantity ticketQuantity = getTicketQuantity();
        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto.getNumbers());

        outputView.printRequestInputBonusNumberMessage();
        inputView.inputBonusNumbers();
    }

    private TicketQuantity getTicketQuantity() {
        outputView.printRequestInputPurchaseAmountMessage();
        while (true) {
            try {
                Integer amount = inputView.inputPurchaseAmount();
                TicketQuantity ticketQuantity = Converter.convertToTicketCount(amount);
                outputView.printTicketQuantityMessage(ticketQuantity.quantity());
                return ticketQuantity;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        outputView.printRequestInputWinningNumberMessage();
        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                List<Integer> numbers = Converter.convertToLottoNumbers(winningNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(final List<Integer> numbers) {
        outputView.printRequestInputBonusNumberMessage();
        while (true) {
            try {
                Integer bonusNumber = inputView.inputBonusNumbers();
                validateBonusNumberContainsWinningNumber(numbers, bonusNumber);
                return new BonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private void validateBonusNumberContainsWinningNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_CONTAINS_WINNING_ERROR_MESSAGE.getMessage());
        }
    }

}
