package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

public class InputView {
    public String getPrice() {
        System.out.println(Constants.GET_PRICE_MESSAGE);
        String price = Console.readLine();
        System.out.println();

        return price;
    }

    public String getWinningNumber() {
        System.out.println(Constants.GET_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        System.out.println();

        return winningNumber;
    }

    public String getBonusNumber() {
        System.out.println(Constants.GET_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        System.out.println();

        return bonusNumber;
    }
}
