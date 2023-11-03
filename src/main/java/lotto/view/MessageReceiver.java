package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

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
            List<String> winningNumbersText = Arrays.asList(inputText.split(COMMA));
            try {
                viewValidator.validateWinningNumberSize(winningNumbersText);
                List<Integer> winningNumbers = viewValidator.validateWinningNumberFormat(winningNumbersText);
                return WinningLotto.of(winningNumbers);

            } catch (IllegalArgumentException e) {
                viewValidator.printExceptionMessage(e);
            }
        } while (true);
    }

    public int receiveBonusNumber() {
        String bonusNumberText = Console.readLine();
        return Integer.parseInt(bonusNumberText);
    }
}
