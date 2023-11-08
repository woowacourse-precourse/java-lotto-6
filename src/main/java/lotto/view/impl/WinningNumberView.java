package lotto.view.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.view.Inputable;
import lotto.view.View;

public class WinningNumberView extends View implements Inputable {
    private final static String INPUT_TEXT = "당첨 번호를 입력해 주세요.";

    @Override
    public Object inputView() {
        Lotto lotto = null;
        boolean validInput = false;

        while (!validInput) {
            printView(INPUT_TEXT);

            try {
                lotto = new Lotto(Console.readLine());
                validInput = true;
            } catch (IllegalArgumentException e) {
                printView(ERROR_MSG + INPUT_ERROR_MSG);

            }
        }

        return lotto;
    }

}
