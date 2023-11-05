package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottosInfo;
import lotto.generator.RandomUniqueListGenerator;

public class Lottos {
    private static final long LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(long money, RandomUniqueListGenerator generator) {
        List<Lotto> randomLottos = new ArrayList<>();
        long quotient = getQuotient(money);
        while (quotient-- != 0) {
            randomLottos.add(Lotto.from(generator.generateRandomNumber()));
        }
        return new Lottos(randomLottos);
    }

    public LottosInfo getLottosInfo() {
        List<String> lottosText = lottos.stream()
                .map(Lotto::toString)
                .toList();
        return new LottosInfo(lottosText);
    }

    private static long getQuotient(long money) {
        return money / LOTTO_PRICE;
    }
}
