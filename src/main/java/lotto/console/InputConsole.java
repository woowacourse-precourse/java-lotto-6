package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ConsoleMessage;
import lotto.model.Lotto;
import lotto.model.Capital;
import lotto.utils.StringUtil;

public class InputConsole {
    public static Capital getCapital() {
        OutputConsole.printInputPrompt(ConsoleMessage.PURCHASE_INPUT);

        String input = Console.readLine();

        try {
            return StringUtil.stringToCapital(input);
        } catch (IllegalArgumentException exception) {
            OutputConsole.printErrorMessage(exception);
            return getCapital();
        }
    }

    public static Lotto getWinningNumbers() {
        OutputConsole.printInputPrompt(ConsoleMessage.WINNING_NUMBERS_INPUT);

        String input = Console.readLine();

        try {
            return StringUtil.stringToLottery(input);
        } catch (IllegalArgumentException exception) {
            OutputConsole.printErrorMessage(exception);
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber() {
        OutputConsole.printInputPrompt(ConsoleMessage.BONUS_NUMBER_INPUT);

        String input = Console.readLine();

        try {
            return StringUtil.stringToInt(input);
        } catch (IllegalArgumentException exception) {
            OutputConsole.printErrorMessage(exception);
            return getBonusNumber();
        }
    }
}
