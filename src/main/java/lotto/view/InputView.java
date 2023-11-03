package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static String inputPurchaseAmount() {
        String amount = Console.readLine();
        return amount;
    }

    public static List<String> inputWinningNumbers() {
        List<String> winningNumbersStr = List.of(Console.readLine().split(","));
        return winningNumbersStr;
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
