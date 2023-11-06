package lotto.controller;

import lotto.model.Lotto;
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

    private static int price;
    private static int count;
    private static HashMap<Rank, Integer> result;
    public Play() {
        price = createPrice();
        count = calLottoCount(price);
        printBoughtLottoCount(count);
        List<Lotto> lottery = rotateLotteryCount(count);
        printLottoRotate(lottery);
        List<Integer> winningNumbers = createWinningNumber();
        int bonus = createBonusNumber(winningNumbers);
        messageAboutWinningStatistic();
        result = createResult(lottery, winningNumbers, bonus);
        calResultPlay();
    }

    public static void boughtLotto() {

    }

    public static void inputWinning() {

    }

    public static void winningResult() {

    }

    public static int createPrice() {
        while(true) {
            messageAboutPrice();
            String tmpPrice = inputPrice();
            try {
                return convertPrice(tmpPrice);
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

    public static int createBonusNumber(List<Integer> numbers) {
        System.out.println();
        while(true) {
            try {
                messageAboutUserBonusNumber();
                String tmpBonusNumber = inputBonusNumber();
                return checkExceptionBonus(numbers,tmpBonusNumber);
            } catch (IllegalArgumentException e) {
                //System.out.println("[ERROR]");
            }
        }
    }

    public static void calResultPlay() {
        printResultRank(result);
        int sumPrize = calSumPrize(result);
        double rateMean = calRate(sumPrize, price);
        printMean(rateMean);
    }

}
