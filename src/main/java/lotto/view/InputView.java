package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int requestPrice() {
        return Integer.parseInt(Console.readLine());
    }

    public static String requestWinningNumber() {
        return Console.readLine();
    }

    public static int requestWinningBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
