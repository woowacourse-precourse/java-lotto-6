package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<Integer> createLottoNumber(int minValue, int maxValue, int uniqueNumbers) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minValue, maxValue, uniqueNumbers);
        return new ArrayList<>(numbers);
    }
}