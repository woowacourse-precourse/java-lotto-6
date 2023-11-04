package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readPayMoney() {
        System.out.println(ViewConstraints.INPUT_MONEY.getMessage());
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
