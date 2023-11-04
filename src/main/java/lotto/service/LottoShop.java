package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.config.AppConfig;
import lotto.domain.Lotto;

public class LottoShop {
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    public static List<Lotto> sell(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> generate())
                .map(Lotto::new)
                .toList();
    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_RANGE, LOTTO_NUMBER_END_RANGE, AppConfig.LOTTO_SIZE);
    }
}
