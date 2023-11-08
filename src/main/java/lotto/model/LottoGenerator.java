package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public static final int NUMBER_OF_LOTTO_NUMBER_IN_GAME = 6;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static List<Integer> makeRandomNumbersInLotto() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER,
                NUMBER_OF_LOTTO_NUMBER_IN_GAME)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
