package lotto.controller;

import lotto.model.*;

import java.util.*;

import static lotto.exception.BonusNumberException.checkBonusNumberException;
import static lotto.controller.InputConverter.*;
import static lotto.controller.InputHandler.*;
import static lotto.controller.Statistic.*;
import static lotto.controller.lotteryController.*;
import static lotto.controller.winningController.*;
import static lotto.exception.PriceException.checkPriceException;
import static lotto.exception.WinningException.checkWinningNumberException;
import static lotto.view.Message.*;
import static lotto.view.Print.*;

public class Play {

    private static Price price;
    private static int count;
    private static HashMap<Rank, Integer> result;
    private static List<Lotto> lottery;
    private static BonusNumber bonus;
    private static WinningNumber winningNumbers;

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
        createWinningNumber();
        createBonusNumber(winningNumbers.getWinningNumbers());
    }

    public static void winningResult() {
        messageAboutWinningStatistic();
        result = createResult(lottery, winningNumbers.getWinningNumbers(), bonus);
        calResultPlay();
    }

    public static void createPrice() {
        while(true) {
            messageAboutPrice();
            String tmpPrice = inputPrice();
            try {
                price = checkPriceException(convertDigit(tmpPrice));
                break;
            } catch (IllegalArgumentException e) {
                //notDigitExceptionMessage();
            }
        }
    }

    public static void createWinningNumber() {
        while(true) {
            messageAboutUserLottoNumber();
            String tmpWinningNumbers = inputWinningNumbers();
            try {
                winningNumbers = checkWinningNumberException(convertWinningNumber(tmpWinningNumbers));
                break;
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
                bonus =  checkBonusNumberException(numbers, convertDigit(tmpBonusNumber));
                break;
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
