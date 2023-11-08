package lotto.view.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.view.Inputable;
import lotto.view.View;

public class BonusNumberView extends View implements Inputable {
    private final static String INPUT_TEXT = "보너스 번호를 입력해 주세요.";

    @Override
    public Object inputView() {
        BonusNumber bonusNumber = null;
        boolean validInput = false;

        while (!validInput) {
            printView(INPUT_TEXT);

            try {
                bonusNumber = new BonusNumber(Console.readLine());
                validInput = true;
            } catch (IllegalArgumentException e) {
                printView(ERROR_MSG + INPUT_ERROR_MSG);
            }
        }

        return bonusNumber;
    }

}
