package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.config.AppConfig;
import lotto.domain.Lotto;

public class LottoShop {

    public static List<Lotto> sell(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> generateLottoNumber())
                .map(Lotto::new)
                .toList();
    }

    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                AppConfig.LOTTO_NUMBER_MIN_RANGE,
                AppConfig.LOTTO_NUMBER_MAX_RANGE,
                AppConfig.LOTTO_SIZE
        );
    }
}
