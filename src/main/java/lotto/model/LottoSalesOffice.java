package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoSalesOffice {

    public List<Lotto> buyLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generate())
                .toList();
    }

    private Lotto generate() {
        List<Integer> RandomNums = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN_NUMBER, Lotto.LOTTO_MAX_NUMBER, Lotto.LOTTO_SIZE)
        );

        Collections.sort(RandomNums);
        return new Lotto(RandomNums);
    }
}
