package lotto.controller.input;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String inputPrice() {
        String price = Console.readLine();
        return price;
    }

    public static String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
