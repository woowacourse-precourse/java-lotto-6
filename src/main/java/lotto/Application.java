package lotto;

//import static lotto.view.OutputView.printStartBuyMessage;

import static lotto.LottoListMaker.makeLottoList;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.calculator.ProfitCalculator.*;
import static lotto.calculator.BuyTicketsCalculator.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        printStartBuyMessage();
        int buyMoney = getBuyMoney();

        System.out.println();

        int lottoCount = getLottoListSize(buyMoney);
        printLottoCount(lottoCount);

        List<Lotto> lottoList = makeLottoList(lottoCount);
        printLottoSet(lottoList);

        System.out.println();

        printGetWinNumberMessage();
        Lotto winLotto = getWinNumber();

        printGetBonusNumberMessage();
        int bonus = getBonusNumber();

        System.out.println();



    }
}
