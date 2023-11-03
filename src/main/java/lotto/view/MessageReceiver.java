package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.view.valid.InputValidation;
import lotto.view.valid.ViewValidator;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.SymbolConstant.COMMA;

public class MessageReceiver {

    private final ViewValidator viewValidator;

    public MessageReceiver(final ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    public int receiveBuyingPrice() {
        do {
            String buyingPriceText = Console.readLine();
            try {
                int buyingPrice = viewValidator.parseInt(buyingPriceText);
                viewValidator.validateMod(buyingPrice);
                return buyingPrice;

            } catch (IllegalArgumentException e) {
                viewValidator.printExceptionMessage(e);
            }
        } while (true);
    }

    public WinningLotto receiveWinningNumbers() {
        do {
            String inputText = Console.readLine();
            try {
                List<String> winningNumbersText = Arrays.asList(inputText.split(COMMA));
                viewValidator.validateWinningNumberSize(winningNumbersText);
                List<Integer> winningNumbers = viewValidator.validateWinningNumberFormat(winningNumbersText);
                return WinningLotto.of(winningNumbers);

            } catch (IllegalArgumentException e) {
                viewValidator.printExceptionMessage(e);
            }
        } while (true);
    }

    public void receiveBonusNumber(final WinningLotto winningLotto) {
        do {
            String bonusNumberText = Console.readLine();
            try {
                int bonusNumber = viewValidator.parseInt(bonusNumberText);
                winningLotto.createBonusNumber(bonusNumber);
                return;
            } catch (IllegalArgumentException e) {
                viewValidator.printExceptionMessage(e);
            }
        } while (true);
    }
}
