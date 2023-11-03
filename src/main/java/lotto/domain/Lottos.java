package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos fromAmount(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        validateAmount(amount);
        int sheet = amount / 1000;

        for (int i = 0; i < sheet; i++) {
            lottos.add(Lotto.from(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return new Lottos(lottos);
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
