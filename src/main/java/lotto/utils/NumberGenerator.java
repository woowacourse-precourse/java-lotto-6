package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.GameRule;

public class NumberGenerator {
    public static List<Integer> generateNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(GameRule.MIN_LOTTO_NUMBER, GameRule.MAX_LOTTO_NUMBER, GameRule.LOTTO_LENGTH);
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
