package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Utils;

public class Input {

    public static String inputAmount() {
        Output.printAmountMessage();
        return Console.readLine();
    }

}
