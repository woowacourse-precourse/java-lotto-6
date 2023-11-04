package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.view.valid.*;

public class MessageReceiver {

    private final ViewValidator viewValidator;
    private final InputValidation<Integer> buyingPriceValidation;
    private final InputValidation<WinningLotto> winningNumberValidation;
    private final InputValidation<Integer> bonusNumberValidation;

    public MessageReceiver(final ViewValidator viewValidator,
                           final InputValidation<Integer> buyingPriceValidation,
                           final InputValidation<WinningLotto> winningNumberValidation,
                           final InputValidation<Integer> bonusNumberValidation) {
        this.viewValidator = viewValidator;
        this.buyingPriceValidation = buyingPriceValidation;
        this.winningNumberValidation = winningNumberValidation;
        this.bonusNumberValidation = bonusNumberValidation;
    }

    public int receiveBuyingPrice() {
        return receiveInput(buyingPriceValidation);
    }

    public WinningLotto receiveWinningNumbers() {
        return receiveInput(winningNumberValidation);
    }

    public void receiveBonusNumber(final WinningLotto winningLotto) {
        int bonusNumber = receiveInput(bonusNumberValidation);
        winningLotto.createBonusNumber(bonusNumber);
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
