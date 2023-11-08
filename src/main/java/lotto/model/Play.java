package lotto.model;

import java.util.HashMap;
import java.util.List;


import static lotto.controller.LottoController.listOfLotto;
import static lotto.controller.WinningController.createResultRotate;
import static lotto.model.Rate.calculateRateOfReturn;
import static lotto.model.Rate.purchaseTicket;
import static lotto.util.inputAgain.*;
import static lotto.view.OutputView.*;

public class Play {
    private static Price price;
    private static int count;
    private static HashMap<Rank, Integer> result;
    private static List<Lotto> lottery;
    private static BonusNumber bonusNumber;
    private static Winning winning;

    public Play() {
        purchaseLotto();
        inputWinning();
        winningResult();
    }

    public static void purchaseLotto() {
        price = createUserPrice();
        count = purchaseTicket(price.getPrice());
        printPurchaseLotto(count);
        lottery = listOfLotto(count);
        printLottoList(lottery);
    }

    public static void inputWinning(){
        winning = createWinningNumber();
        bonusNumber = createBonusNumber(winning.getWinning());

    }
    public static void winningResult(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        result = createResultRotate(lottery, winning, bonusNumber);
        printResultRank(result);
        printCalRate(calculateRateOfReturn(result,price));
    }
}
