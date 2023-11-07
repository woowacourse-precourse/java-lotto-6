package lotto.controller;

import lotto.controller.result.Rank;
import lotto.controller.result.WinningRate;
import lotto.model.*;

import java.util.*;

import static lotto.controller.input.createObject.*;
import static lotto.controller.result.WinningRate.*;
import static lotto.controller.lotto.lotteryController.*;
import static lotto.controller.result.winningController.*;
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
        price = createPrice();
        count = calLottoCount(price.getPrice());
        printBoughtLottoCount(count);
        lottery = rotateLotteryCount(count);
        printLottoRotate(lottery);
    }

    public static void inputWinning() {
        winningNumbers = createWinningNumber();
        bonus = createBonusNumber(winningNumbers.getWinningNumbers());
    }

    public static void winningResult() {
        messageAboutWinningStatistic();
        result = createResultRotate(lottery, winningNumbers, bonus);
        printResultRank(result);
        printMean(calResultPlay(result, price));
    }

}
