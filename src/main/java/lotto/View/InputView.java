package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message.InputMessage;

public class InputView {
    public static String totalCost() {
        System.out.println(InputMessage.TOTAL_COST);
        return Console.readLine();
    }
}
