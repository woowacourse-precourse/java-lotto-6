package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNums {
    private static final int NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static List<Integer> lottoNumberList;

    public LottoNums() {

    }

    public static List<Integer> setRandomNums() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        List<Integer> lottoPurchased = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoPurchased);

        return lottoPurchased;
    }
}
