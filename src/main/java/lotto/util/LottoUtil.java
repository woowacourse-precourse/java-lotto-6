package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {
    public static List<Integer> generateRandomNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static List<Integer> sortNumbersAscending(List<Integer> numbers) {
        List<Integer> orderedList = new ArrayList<Integer>(numbers);
        Collections.sort(orderedList);
        return orderedList;
    }
}
