package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int makeOrder() {
        String order = Console.readLine();
        return Integer.parseInt(order);
    }
}
