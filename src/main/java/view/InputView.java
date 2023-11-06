package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputSpend() {
        String spend = Console.readLine();
        return Integer.parseInt(spend);
    }
}
