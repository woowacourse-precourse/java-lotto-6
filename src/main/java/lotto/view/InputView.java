package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

public class InputView {
    public String getPrice() {
        System.out.println(Constants.GET_PRICE_MESSAGE);

        return Console.readLine();
    }

    public String getWinningNumber() {
        System.out.println(Constants.GET_WINNING_NUMBER_MESSAGE);

        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(Constants.GET_BONUS_NUMBER_MESSAGE);

        return Console.readLine();
    }
}
