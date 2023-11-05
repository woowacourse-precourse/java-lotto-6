package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottosInfo;
import lotto.generator.RandomUniqueListGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(PurchasePrice purchasePrice, RandomUniqueListGenerator generator) {
        List<Lotto> randomLottos = new ArrayList<>();
        long quotient = purchasePrice.getQuotient();
        while (quotient-- != 0) {
            randomLottos.add(Lotto.from(generator.generateRandomNumber()));
        }
        return new Lottos(randomLottos);
    }

    public LottosInfo convertLottosIntoLottosInfo() {
        List<String> lottosText = lottos.stream()
                .map(Lotto::toString)
                .toList();
        return new LottosInfo(lottosText);
    }
}
