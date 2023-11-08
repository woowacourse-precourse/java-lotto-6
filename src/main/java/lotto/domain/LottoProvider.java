package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoProvider {
    private LottoProvider() {
    }

    public static List<Lotto> provideByPurchaseQuantity(
            final LottoGenerator lottoGenerator,
            final int purchaseQuantity
    ) {
        return Stream.generate(() -> Lotto.create(lottoGenerator.get()))
                .limit(purchaseQuantity)
                .toList();
    }
}
