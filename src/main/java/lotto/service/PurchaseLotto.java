package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class PurchaseLotto {
    public static List<Lotto> getLottos(int n) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

    private static Lotto getLotto() {
        return new Lotto(getRandomNumbers());
    }

    private static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
