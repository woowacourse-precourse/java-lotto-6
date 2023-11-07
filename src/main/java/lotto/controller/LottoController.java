package lotto.controller;

import static lotto.constants.InputMessage.DEMAND_INPUT_BUDGET;
import static lotto.util.InputUtils.readInt;
import static lotto.view.InputView.println;

public class LottoController {

    public void play() {
        println(DEMAND_INPUT_BUDGET.getMessage());
        readInt();
    }
}
