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
        boolean validInput = false;
        int buyingPrice = 0;

        while (!validInput) {
            validInput = viewValidator.validateBuyingPrice();
        }

        return buyingPrice;
    }

    public WinningLotto receiveWinningNumbers() {
        boolean validInput = false;
        WinningLotto winningLotto = null;

        while (!validInput) {
            String winningNumbersText = Console.readLine();
            List<String> winningNumbers = Arrays.asList(winningNumbersText.split(COMMA));
            validInput = viewValidator.validateWinningNumbers(winningNumbers);
            winningLotto = WinningLotto.of(winningNumbers);
        }

        return winningLotto;
    }

    public int receiveBonusNumber() {
        String bonusNumberText = Console.readLine();
        return Integer.parseInt(bonusNumberText);
    }
}
