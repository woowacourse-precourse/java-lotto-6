package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoEnum;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonHelper {
    public static int strToInt(String input) {
        return Integer.parseInt(input);
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static List<Integer> listSort(List<Integer> unSortedList) {
        Collections.sort(unSortedList);
        return unSortedList;
    }


    public static List<Integer> numGenerator() {
        return Randoms.pickUniqueNumbersInRange(LottoEnum.LOTTO_MIN_NUMBER.getValue(), LottoEnum.LOTTO_MAX_NUMBER.getValue(), LottoEnum.LOTTO_SIZE.getValue());
    }

    public static List<Integer> splitComma(String input) {
        List<String> splited = List.of(input.split(","));
        return splited.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int countSameNumber(List<Integer> userLottoNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        Set<Integer> set = new HashSet<>(userLottoNumbers);
        for (Integer num : lottoNumbers) {
            if (set.contains(num)) {
                count++;
            }
        }
        return count;
    }
}
