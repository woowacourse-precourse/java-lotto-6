package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Constants;

public class InputView {

    public Integer enterPriceToBuy() {
        System.out.println(Constants.ENTER_PRICE_TO_BUY_MESSAGE);
        String priceToBuy = Console.readLine();
        System.out.println();
        return Integer.parseInt(priceToBuy);
    }
    public int enterBonusNumber() {
        System.out.println();
        System.out.println(Constants.ENTER_BONUS_NUMBER_MESSAGE);
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public String enterWinningNumber() {
        System.out.println();
        System.out.println(Constants.ENTER_WINNING_NUMBER_MESSAGE);
        String getWinningNumbers = Console.readLine();
        return getWinningNumbers;
    }
}
