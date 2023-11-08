package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.OutputMessage;

public class Input {
    public String inputCost() {
        System.out.println(OutputMessage.ENTER_AMOUNT_MESSAGE);

        String cost = Console.readLine();

        System.out.println();

        return cost;
    }

    public String inputLotto() {

    }

    public String inputBonus() {

    }
}
