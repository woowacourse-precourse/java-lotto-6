package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Winning;

import java.util.*;

import static lotto.controller.InputConverter.*;
import static lotto.controller.InputHandler.*;
import static lotto.controller.RandNumber.*;
import static lotto.controller.Statistic.*;
import static lotto.controller.lotteryController.*;
import static lotto.controller.winningController.*;
import static lotto.view.Message.*;
import static lotto.view.Print.*;

public class Play {

    private static final int lottoPrice = 1000;
    private static final int size = 6;
    public static HashMap<Rank, Integer> result;
    public static List<Lotto> lottery;
    public Play() {
        result = new HashMap<>();
        int price = createPrice();
        int count = calLottoCount(price, lottoPrice);
        printBoughtLottoCount(count);
        lottery = rotateLotteryCount(count);

        for (Lotto lotto : lottery) {
            printLottoNumber(sortLottery(lotto));
        }

        System.out.println();
        List<Integer> winningNumbers = createWinningNumber();

        System.out.println();
        int bonus = createBonusNumber();

        Winning winning = new Winning(winningNumbers, bonus);
        System.out.println();
        messageAboutWinningStatistic();

        for (Lotto lotto : lottery) {
            int resultCount = compareLottoAndWinningNumber(lotto.getLotto(), winningNumbers);
            Rank resultRank = findRank(resultCount);
            if (resultRank == null) {
                continue;
            }
            if (resultRank.getCorrectNum() == 5) {
                resultRank = checkIfSecondOrThird(lotto, bonus);
            }
            result.put(resultRank, result.getOrDefault(resultRank, 0)+1);
        }
        printResultRank(result);

        int sumPrize = calSumPrize(result);
        double rateMean = calRate(sumPrize, price);
        printMean(rateMean);

    }

    public static int createPrice() {
        messageAboutPrice();
        String tmpPrice = inputPrice();
        int price = 0;
        try {
            price = convertPrice(tmpPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            createPrice();
            //e.getMessage();
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
