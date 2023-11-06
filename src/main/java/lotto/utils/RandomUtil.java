package lotto.utils;

import static lotto.constant.SystemConstant.NUMBER_COUNT;
import static lotto.constant.SystemConstant.NUMBER_MAX;
import static lotto.constant.SystemConstant.NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUtil {
    public static List<Integer> createLottoNumber() {
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(NUMBER_MIN, NUMBER_MAX, NUMBER_COUNT);
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
