package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.view.valid.*;

public class MessageReceiver {

    private final ViewValidator viewValidator;
    private final BuyingPriceValidation buyingPriceValidation;
    private final WinningNumberValidation winningNumberValidation;
    private final BonusNumberValidation bonusNumberValidation;

    public MessageReceiver(final ViewValidator viewValidator,
                           final BuyingPriceValidation buyingPriceValidation,
                           final WinningNumberValidation winningNumberValidation,
                           final BonusNumberValidation bonusNumberValidation) {
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
        bonusNumberValidation.assignWinningLotto(winningLotto);
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
