package lotto;

//import static lotto.view.OutputView.printStartBuyMessage;

import static lotto.LottoListMaker.makeLottoList;
import static lotto.calculator.ScoreCalculator.getScore;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.calculator.ProfitCalculator.*;
import static lotto.calculator.BuyTicketsCalculator.*;

import java.util.HashMap;
import java.util.List;

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

        System.out.println();

        printGetBonusNumberMessage();
        int bonus = getBonusNumber(winLotto);

        System.out.println();

        HashMap<String, Integer> finalScore = getScore(lottoList, winLotto, bonus);
        int prize = caculatePrize(finalScore);
        double yield = caculateProfit(prize, buyMoney);
        printWinningStatistics(finalScore, yield);


    }
}
