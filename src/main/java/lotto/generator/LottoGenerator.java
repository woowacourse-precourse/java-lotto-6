package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Money;

public class LottoGenerator {

    public static LottoBundle generateLottoBundle(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money.getNumberOfLotto(); i++) {
            lottos.add(generateLotto());
        }

        return new LottoBundle(lottos);
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
