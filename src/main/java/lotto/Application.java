package lotto;

//import static lotto.view.OutputView.printStartBuyMessage;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.calculator.ProfitCalculator.*;

public class Application {
    public static void main(String[] args) {
        printStartBuyMessage();
        int buyMoney = getBuyMoney();

        System.out.println();

        System.out.println(printLottoCount());


        printGetWinNumberMessage();
        Lotto winNumber = getWinNumber();

    }
}
