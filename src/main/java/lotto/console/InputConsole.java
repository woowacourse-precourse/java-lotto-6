package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ConsoleMessage;
import lotto.model.Lotto;
import lotto.model.Capital;
import lotto.utils.StringUtil;

public class InputConsole {
    public static Capital getCapital() {
        String input = getInput(ConsoleMessage.PURCHASE_INPUT);

        try {
            return StringUtil.stringToCapital(input);
        } catch (IllegalArgumentException exception) {
            OutputConsole.printErrorMessage(exception);
            return getCapital();
        }
    }

    public static Lotto getWinningNumbers() {
        String input = getInput(ConsoleMessage.WINNING_NUMBERS_INPUT);

        try {
            return StringUtil.stringToLottery(input);
        } catch (IllegalArgumentException exception) {
            OutputConsole.printErrorMessage(exception);
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber(Lotto winningLotto) {
        String input = getInput(ConsoleMessage.BONUS_NUMBER_INPUT);
        
        try {
            int bonusNumber = StringUtil.stringToInt(input);
            if (winningLotto.containsNumber(bonusNumber)) {
                throw new IllegalArgumentException(ConsoleMessage.DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE);
            }
            return bonusNumber;
        } catch (IllegalArgumentException exception) {
            OutputConsole.printErrorMessage(exception);
            return getBonusNumber(winningLotto);
        }
    }

    private static String getInput(String promptMessage) {
        OutputConsole.printInputPrompt(promptMessage);
        return Console.readLine();
    }
}
