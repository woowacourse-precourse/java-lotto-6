package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Constants;

public class GetWinningNumbersUI {

    public String enterWinningNumbersUI() {

        System.out.println();
        System.out.println(Constants.ENTER_WINNING_NUMBERS);

        return readLine();
    }

    public String enterBonusNumberUI() {
        System.out.println();
        System.out.println(Constants.ENTER_BONUS_NUMBER);

        return readLine();
    }
}
