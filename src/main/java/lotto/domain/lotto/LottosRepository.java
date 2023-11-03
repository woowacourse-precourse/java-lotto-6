package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottosRepository {

    private final Map<LottoType, Lottos> stores = new HashMap<>();

    public void saveUserLottos(final Lottos lottos) {
        stores.put(LottoType.USER_LOTTO, lottos);
    }
}
