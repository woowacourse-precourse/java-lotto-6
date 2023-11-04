package lotto.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Play {

    private static final int lottoPrice = 1000;
    private static final int size = 6;
    public static int calLottoCount(int price) {
        return price / lottoPrice;
    }

    public static int compareLottoAndWinning(List<Integer> lotto, List<Integer> winning) {
        Set<Integer> uniqueLotto = new HashSet<>(lotto);
        Set<Integer> uniqueWinning = new HashSet<>(winning);

        uniqueLotto.retainAll(uniqueWinning);
        return uniqueLotto.size();
    }



}
