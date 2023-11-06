package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.generator.NumberGenerator;

public class PurchasedLottos {
    private static final int START_INDEX = 0;

    private final List<Lotto> purchasedLottos;

    private PurchasedLottos(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public static PurchasedLottos createPurchasedLottos(NumberGenerator generator, Money money) {
        List<Lotto> lottos = IntStream.range(START_INDEX, money.calculateLottoPurchaseSize())
                .mapToObj(i -> Lotto.createLotto(generator))
                .collect(Collectors.toList());
        return new PurchasedLottos(lottos);
    }

    public int purchasedLottosCount() {
        return purchasedLottos.size();
    }

    public List<List<String>> getCurrentPurchasedLottosSnapshot() {
        return purchasedLottos.stream()
                .map(lotto -> lotto.getLottoNumberStrings())
                .collect(Collectors.toList());
    }

    public List<LottoRank> matchLottos(WinningLotto winningLotto) {
        return purchasedLottos.stream()
                .map(purchasedLotto -> winningLotto.matcheLotto(purchasedLotto))
                .collect(Collectors.toList());
    }
}
