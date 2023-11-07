package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ViewConsts;

public class ConsoleInputView implements InputView {
    @Override
    public String inputPurchasingMoney() {
        printMessage(ViewConsts.INPUT_PURCHASING_COST.getMessage());
        return inputMessage();
    }

    @Override
    public String inputWinningLottoNumbers() {
        printMessage(ViewConsts.INPUT_WINNING_NUMBERS.getMessage());
        return inputMessage();
    }

    @Override
    public String inputBonusNumber() {
        printMessage(ViewConsts.INPUT_BONUS_NUMBER.getMessage());
        return inputMessage();
    }

    @Override
    public void printMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public String inputMessage() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
