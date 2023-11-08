package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    public static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER.getValues(),
                Constants.MAX_LOTTO_NUMBER.getValues(),
                Constants.LOTTO_COUNT.getValues());
        return numbers.stream().sorted().toList();
    }
}
