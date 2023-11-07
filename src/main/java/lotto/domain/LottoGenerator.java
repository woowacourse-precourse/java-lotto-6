package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.Constants;

public class LottoGenerator {

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.LOTTO_NUM_MIN, Constants.LOTTO_NUM_MAX,
                Constants.LOTTO_NUM_COUNT);
        Collections.sort(numbers);
        return numbers;
    }

    public static List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
