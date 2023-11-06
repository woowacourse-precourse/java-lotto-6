package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    public static String inputWinningNumbers() {
        return Console.readLine();
    }

    public static int inputSpend() {
        String spend = Console.readLine();
        return Integer.parseInt(spend);
    }
}
