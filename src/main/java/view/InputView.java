package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Constants;

public class InputView {

    public Integer enterPriceToBuy() {
        System.out.println(Constants.enterPriceToBuyMessage);
        String priceToBuy = Console.readLine();
        return Integer.parseInt(priceToBuy);
    }
}
