package lotto.controller;

import lotto.model.Lotto;

import java.util.*;

import static lotto.controller.InputConverter.convertPrice;
import static lotto.controller.InputHandler.inputPrice;
import static lotto.controller.RandNumber.checkDuplicate;
import static lotto.controller.RandNumber.makeRandNumber;
import static lotto.controller.Rank.getRank;
import static lotto.view.Message.messageAboutPrice;
import static lotto.view.Print.printBoughtLottoCount;

public class Play {

    private static final int lottoPrice = 1000;
    private static final int size = 6;
    public HashMap<Rank, Integer> result;
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
    }

    public static Lotto makeLottery() {
        Lotto lotto = null;

        List<Integer> number = makeRandNumber();
        number = checkDuplicate(number);
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

}
