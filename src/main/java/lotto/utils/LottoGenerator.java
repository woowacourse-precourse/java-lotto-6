package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    public static List<Integer> generateLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER.getValues(),
                Constants.MAX_LOTTO_NUMBER.getValues(),
                Constants.LOTTO_COUNT.getValues());
        return numbers.stream().sorted().toList();
    }
}
