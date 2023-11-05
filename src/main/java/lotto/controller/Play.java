package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Winning;

import java.util.*;

import static lotto.controller.InputConverter.*;
import static lotto.controller.InputHandler.*;
import static lotto.controller.RandNumber.*;
import static lotto.controller.Rank.getRank;
import static lotto.view.Message.*;
import static lotto.view.Print.*;

public class Play {

    private static final int lottoPrice = 1000;
    private static final int size = 6;
    public static HashMap<Rank, Integer> result;
    public static List<Lotto> lottery;

    public Play() {
        result = new HashMap<>();
        messageAboutPrice();
        String tmpPrice = inputPrice();
        int price = convertPrice(tmpPrice);

        int count = calLottoCount(price);
        printBoughtLottoCount(count);
        lottery = new ArrayList<>();

        for (int i=0; i<count; i++) {
            lottery.add(makeLottery());
        }

        for (Lotto lotto : lottery) {
            printLottoNumber(sortLottery(lotto));
        }

        System.out.println();
        messageAboutUserLottoNumber();
        String tmpWinningNumbers = inputWinningNumbers();
        List<Integer> winningNumbers = convertWinningNumber(tmpWinningNumbers);

        System.out.println();
        messageAboutUserBonusNumber();
        String tmpBonusNumber = inputBonusNumber();
        int bonus = convertBonusNumber(tmpBonusNumber);

        Winning winning = new Winning(winningNumbers, bonus);
        System.out.println();
        messageAboutWinningStatistic();

        for (Lotto lotto : lottery) {
            int resultCount = compareLottoAndWinning(lotto.getLotto(), winningNumbers);
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

        int sumPrize = calSumPrize();
        double rateMean = calRate(sumPrize, price);
        printMean(rateMean);

    }

    public static Lotto makeLottery() {
        Lotto lotto = null;
        List<Integer> number = makeUniqueNumber();;
        lotto = new Lotto(number);

        return lotto;
    }


    public static int calLottoCount(int price) {
        return price / lottoPrice;
    }

    public static int compareLottoAndWinning(List<Integer> lotto, List<Integer> winning) {
        Set<Integer> uniqueLotto = new HashSet<>(lotto);
        Set<Integer> uniqueWinning = new HashSet<>(winning);

        uniqueLotto.retainAll(uniqueWinning);
        return uniqueLotto.size();
    }

    public static boolean compareLottoAndBonus(List<Integer> lotto, int bonus) {
        Set<Integer> uniqueLotto = new HashSet<>(lotto);
        return uniqueLotto.contains(bonus);
    }

    public static Rank findRank(int resultCount) {
        Rank rank = getRank(resultCount);
        if (rank != null) {
            return rank;
        }
        return null;
    }

    //TODO : getLotto 이름 바꾸기
    public static Rank checkIfSecondOrThird(Lotto lotto, int bonus) {
        if (compareLottoAndBonus(lotto.getLotto(), bonus)) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    public static int calSumPrize() {
        int sum = 0;
        for (Rank rank : result.keySet()) {
            sum += (rank.getPrize()*result.get(rank));
        }
        return sum;
    }
    public static double calRate(int resultSum, int price) {
        return ((double)resultSum/(price))*100;
    }

    public static List<Integer> sortLottery(Lotto lotto) {
        List<Integer> sortNumbers = new ArrayList<>(lotto.getLotto());
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

}
