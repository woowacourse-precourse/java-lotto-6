package lotto.view;

import lotto.view.constant.OutputConstant;
import lotto.view.message.OutputMessage;

public class OutputView {
    public void askToInsertUserMoney() {
        printMessage(OutputMessage.ASK_TO_INSERT_USER_MONEY.getMessage() + OutputConstant.NEW_LINE);
    }

    public void askUserToInsertLottoWinningNumbers() {
        printMessage(OutputMessage.ASK_TO_INSERT_LOTTO_WINNING_NUMBERS.getMessage() + OutputConstant.NEW_LINE);
    }

    public void askUserToInsertBonusNumber() {
        printMessage(OutputMessage.ASK_TO_INSERT_LOTTO_BONUS_NUMBER.getMessage() + OutputConstant.NEW_LINE);
    }

    public void printNumberOfLottos(long numberOfLottos) {
        printMessage(numberOfLottos + OutputMessage.PRINT_NUMBER_OF_LOTTOS.getMessage() + OutputConstant.NEW_LINE);
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}