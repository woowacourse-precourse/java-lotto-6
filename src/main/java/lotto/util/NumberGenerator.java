package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator implements LottoConstant {
    public static List<Integer> generateOrderedNumbers() {
        List<Integer> randomNumbers = generateNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_COUNT);
    }
}
