package lotto;

//import static lotto.view.OutputView.printStartBuyMessage;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.calculator.ProfitCalculator.*;
import static lotto.calculator.BuyTicketsCalculator.*;

public class Application {
    public static void main(String[] args) {
        printStartBuyMessage();
        int buyMoney = getBuyMoney();

        System.out.println();

        int lottoCount = getLottoListSize(buyMoney);
        printLottoCount(lottoCount);


    }
}
