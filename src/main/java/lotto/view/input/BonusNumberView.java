package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.util.constants.InputConstants;

public class BonusNumberView implements Input{
    @Override
    public String getInput() {
        System.out.println(InputConstants.INPUT_BONUS_NUMBER.getConstants());
        return readLine();
    }
}
