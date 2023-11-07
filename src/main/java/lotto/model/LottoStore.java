package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.LottoConstants.*;

public class LottoStore {

    public List<Lotto> sellLottos(int money) {
        int lottoCount = calculateLottoCount(money);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateRandomLotto())
                .collect(Collectors.toList());
    }

    private Integer calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, LOTTO_NUMBERS_SIZE);
        return new Lotto(randomNumbers);
    }
}
