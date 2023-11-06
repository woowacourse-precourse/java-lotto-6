package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottosInfo;
import lotto.generator.IntegerListGenerator;

public class LottoOwner {
    private final PurchasePrice purchasePrice;
    private final List<Lotto> lottos;

    private LottoOwner(PurchasePrice purchasePrice, List<Lotto> lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    public static LottoOwner of(PurchasePrice purchasePrice, IntegerListGenerator generator) {
        List<Lotto> randomLottos = new ArrayList<>();
        long quotient = purchasePrice.getQuotient();
        while (quotient-- != 0) {
            randomLottos.add(Lotto.from(generator.generateIntegerList()));
        }
        return new LottoOwner(purchasePrice, randomLottos);
    }

    public LottosInfo getLottosInfo() {
        List<String> lottosText = lottos.stream()
                .map(Lotto::toString)
                .toList();
        return new LottosInfo(lottosText);
    }
}
