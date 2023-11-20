package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ConsoleMessage;

public class InputView {

    public String askForPrice() {
        System.out.print(ConsoleMessage.ASK_FOR_PRICE.getMessage());
        System.out.print(ConsoleMessage.LINE_BREAK.getMessage());
        String price = Console.readLine();

        return price;
    }

    public String askForWinningNumber() {
        System.out.print(ConsoleMessage.LINE_BREAK.getMessage());
        System.out.print(ConsoleMessage.ASK_FOR_WINNING_NUMBER.getMessage());
        System.out.print(ConsoleMessage.LINE_BREAK.getMessage());
        String winningNumber = Console.readLine();

        return winningNumber;
    }

    public String askForBonusNumber() {
        System.out.print(ConsoleMessage.ASK_FOR_BONUS_NUMBER.getMessage());
        System.out.print(ConsoleMessage.LINE_BREAK.getMessage());
        String bonusNumber = Console.readLine();

        return bonusNumber;
    }
}
