package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.util.constants.InputConstants;

public class AmountView implements Input {

    @Override
    public String getInput() {
        System.out.println(InputConstants.INPUT_AMOUNT.getConstants());
        return readLine();
    }
}
