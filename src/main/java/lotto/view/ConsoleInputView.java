package lotto.view;

import static lotto.messages.InputMessages.BONUS_NUMBER_MESSAGE;
import static lotto.messages.InputMessages.PURCHASE_AMOUNT_MESSAGE;
import static lotto.messages.InputMessages.WINNING_LOTTO_MESSAGE;

import lotto.util.InputUtil;
import lotto.util.OutputUtil;

public class ConsoleInputView implements InputView {
    @Override
    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE.getMessage());
        String input = InputUtil.inputString();
        OutputUtil.printEmptyLine();

        return input;
    }

    @Override
    public String inputWinningLotto() {
        System.out.println(WINNING_LOTTO_MESSAGE.getMessage());
        String input = InputUtil.inputString();
        OutputUtil.printEmptyLine();

        return input;
    }

    @Override
    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE.getMessage());
        String input = InputUtil.inputString();
        OutputUtil.printEmptyLine();

        return input;
    }

}
