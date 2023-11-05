package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Winning;

import java.util.*;

import static lotto.controller.InputConverter.*;
import static lotto.controller.InputHandler.*;
import static lotto.controller.Statistic.*;
import static lotto.controller.lotteryController.*;
import static lotto.controller.winningController.*;
import static lotto.view.Message.*;
import static lotto.view.Print.*;

public class Play {

    public static boolean flag  = false;
    public Play() {
        HashMap<Rank, Integer> result = new HashMap<>();
        int price = createPrice();
        System.out.println(price);
        int count = calLottoCount(price);
        printBoughtLottoCount(count);
        List<Lotto> lottery = rotateLotteryCount(count);
        printLottoRotate(lottery);
        List<Integer> winningNumbers = createWinningNumber();

        System.out.println();
        int bonus = createBonusNumber();

        Winning winning = new Winning(winningNumbers, bonus);
        System.out.println();
        messageAboutWinningStatistic();

        result = createResult(lottery, winningNumbers, bonus);
        printResultRank(result);

        int sumPrize = calSumPrize(result);
        double rateMean = calRate(sumPrize, price);
        printMean(rateMean);

    }

    public static int createPrice() {
        int price = 0;
        while(true) {
            messageAboutPrice();
            String tmpPrice = inputPrice();
            try {
                price = convertPrice(tmpPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
        return price;
    }

    public static List<Integer> createWinningNumber() {
        messageAboutUserLottoNumber();
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            String tmpWinningNumbers = inputWinningNumbers();
            winningNumbers = convertWinningNumber(tmpWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            createWinningNumber();
            //e.getMessage();
        }
        return winningNumbers;
    }

    public static int createBonusNumber() {
        messageAboutUserBonusNumber();
        int bonus = 0;
        try {
            String tmpBonusNumber = inputBonusNumber();
            bonus = convertBonusNumber(tmpBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            createBonusNumber();
        }

        return bonus;
    }




}
