package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.view.valid.InputValidation;
import lotto.view.valid.ViewValidator;

public class MessageReceiver {

    private final ViewValidator viewValidator;

    public MessageReceiver(final ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    public int receiveBuyingPrice(final InputValidation<Integer> buyingPriceValidation) {
        return receiveInput(buyingPriceValidation);
    }

    public WinningLotto receiveWinningNumbers(final InputValidation<WinningLotto> winningNumberValidation) {
        return receiveInput(winningNumberValidation);
    }

    public void receiveBonusNumber(final InputValidation<Void> bonusNumberValidation) {
        receiveInput(bonusNumberValidation);
    }

    private <T> T receiveInput(final InputValidation<T> inputValidation) {
        do {
            String inputText = Console.readLine();
            try {
                return inputValidation.validateInput(inputText, viewValidator);

            } catch (IllegalArgumentException e) {
                viewValidator.printExceptionMessage(e);
            }
        } while (true);
    }
}
