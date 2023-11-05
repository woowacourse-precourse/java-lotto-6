package lotto.utils;

import static lotto.constants.Rule.LOTTO_SIZE;
import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.PlayerAmount;

public class Generator {
    public static PlayerAmount generateIntegerToPlayerAmount(int money) {
        return PlayerAmount.getInstance(money);
    }

    public static List<Integer> generateLottoNumbers() {
        return generateRandomNumbers().stream().sorted().collect(Collectors.toList());
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO.getValue(), MAX_LOTTO.getValue(), LOTTO_SIZE.getValue());
    }
}
