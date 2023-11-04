package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(Lotto.from(numbers));
        }
    }

    public static Lottos from(int count) {
        return new Lottos(count);
    }
}
