package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.EnterLottoWinningNumberConstants.*;

public class EnterLottoWinningNumberView {
    public String enterLottoWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER);
        return readLine();
    }

    public String enterAdditionNumber() {
        System.out.println(ENTER_ADDITION_NUMBER);
        return readLine();
    }
}
