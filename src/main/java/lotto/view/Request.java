package lotto.view;

import static lotto.view.OutputView.ASK_INPUT_MONEY;

import camp.nextstep.edu.missionutils.Console;

public class Request {
    public static String requestNubmer() {
        printMessage(ASK_INPUT_MONEY);
        return Console.readLine();
    }

    public static void printMessage(OutputView outputView) {
        System.out.println(outputView.getMessage());
    }
}
