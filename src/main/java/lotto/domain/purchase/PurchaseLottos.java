package lotto.domain.purchase;

import java.util.List;
import java.util.StringJoiner;
import lotto.domain.Lotto;

public record PurchaseLottos(
        List<Lotto> lottos
) {

    @Override
    public String toString() {
        return new StringJoiner(", ", PurchaseLottos.class.getSimpleName() + "[", "]")
                .add("lottos=" + lottos)
                .toString();
    }

}
