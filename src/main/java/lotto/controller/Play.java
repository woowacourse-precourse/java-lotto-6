package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Price;

import java.util.*;

import static lotto.controller.InputConverter.*;
import static lotto.controller.InputHandler.*;
import static lotto.controller.Statistic.*;
import static lotto.controller.ExceptionController.checkExceptionBonus;
import static lotto.controller.ExceptionController.checkExceptionWinningNumber;
import static lotto.controller.lotteryController.*;
import static lotto.controller.winningController.*;
import static lotto.view.ErrorMessage.notDigitExceptionMessage;
import static lotto.view.Message.*;
import static lotto.view.Print.*;

public class Play {

    private static Price price;
    private static int count;
    private static HashMap<Rank, Integer> result;
    private static List<Lotto> lottery;
    private static BonusNumber bonus;
    private static List<Integer> winningNumbers;

    public Play() {
        boughtLotto();
        inputWinning();
        winningResult();
    }

    public static void boughtLotto() {
        createPrice();
        count = calLottoCount(price.getPrice());
        printBoughtLottoCount(count);
        lottery = rotateLotteryCount(count);
        printLottoRotate(lottery);
    }

    public static void inputWinning() {
        winningNumbers = createWinningNumber();
        createBonusNumber(winningNumbers);
    }

    public static void winningResult() {
        messageAboutWinningStatistic();
        result = createResult(lottery, winningNumbers, bonus);
        calResultPlay();
    }

    public static void createPrice() {
        while(true) {
            messageAboutPrice();
            String tmpPrice = inputPrice();
            try {
                price = new Price(convertPrice(tmpPrice));
                break;
            } catch (IllegalArgumentException e) {
                //notDigitExceptionMessage();
            }
        }
    }

    public static List<Integer> createWinningNumber() {
        while(true) {
            try {
                messageAboutUserLottoNumber();
                String tmpWinningNumbers = inputWinningNumbers();
                return checkExceptionWinningNumber(tmpWinningNumbers);
            } catch (IllegalArgumentException e) {
                //notDigitExceptionMessage();
            }
        }
    }

    public static void createBonusNumber(List<Integer> numbers) {
        System.out.println();
        while(true) {
            messageAboutUserBonusNumber();
            String tmpBonusNumber = inputBonusNumber();
            try {
                bonus = new BonusNumber(convertBonusNumber(tmpBonusNumber));
                checkExceptionBonus(numbers,tmpBonusNumber);
            } catch (IllegalArgumentException e) {
                //System.out.println("[ERROR]");
            }
        }
    }

    public static void calResultPlay() {
        printResultRank(result);
        int sumPrize = calSumPrize(result);
        double rateMean = calRate(sumPrize, price.getPrice());
        printMean(rateMean);
    }

}
