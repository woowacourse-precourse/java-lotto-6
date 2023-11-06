package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final Integer LOTTO_PRICE = 1000;
    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 45;
    private static final Integer RANDOM_NUMBER_SIZE = 6;

    public List<Lotto> sellLottos(int money) {
        int lottoCount = calculateLottoCount(money);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateRandomLottoNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private Integer calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, RANDOM_NUMBER_SIZE);
    }
}
