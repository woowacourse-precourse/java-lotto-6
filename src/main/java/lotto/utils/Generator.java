package lotto.utils;

import static lotto.utils.Constant.LOTTO_SIZE;
import static lotto.utils.Constant.MAX_LOTTO;
import static lotto.utils.Constant.MIN_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {
    public static List<Integer> generateSortedLottoNumbers() {
        return generateRandomNumbers().stream().sorted().collect(Collectors.toList());
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO.getValue(), MAX_LOTTO.getValue(), LOTTO_SIZE.getValue());
    }
}
