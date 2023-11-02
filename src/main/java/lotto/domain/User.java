package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class User {
    private static final int LOTTO_PURCHASE_UNIT = 1000;

    private final List<Lotto> lottos;

    private User(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static User provideLottos(final List<Lotto> lottos) {
        return new User(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public BigDecimal calculateLottoPurchaseMoney() {
        final BigDecimal purchaseAmount = BigDecimal.valueOf(lottos.size());
        return BigDecimal.valueOf(LOTTO_PURCHASE_UNIT).multiply(purchaseAmount);
    }
}
