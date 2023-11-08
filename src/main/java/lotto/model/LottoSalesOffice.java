package lotto.model;

import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;
import static lotto.model.Lotto.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoSalesOffice {

    public List<Lotto> buyLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generate())
                .toList();
    }

    private Lotto generate() {
        List<Integer> randomNums =
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);

        return new Lotto(randomNums.stream().sorted().toList());
    }
}
