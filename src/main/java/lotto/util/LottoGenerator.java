package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConsts.*;

public class LottoGenerator {

    public static Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, REQUIRED_COUNT);
            lottos.add(new Lotto(numbers));
        }

        return new Lottos(lottos);
    }

}
