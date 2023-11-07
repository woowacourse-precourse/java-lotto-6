package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.model.LottoNumber.MAX_LOTTO_NUMBER_RANGE;
import static lotto.model.LottoNumber.MIN_LOTTO_NUMBER_RANGE;

public class LottoStore {
    public static final Integer LOTTO_PRICE = 1000;

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
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_RANGE, LOTTO_NUMBERS_SIZE);
        return Lotto.from(randomNumbers);
    }
}
