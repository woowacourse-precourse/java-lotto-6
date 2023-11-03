package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottosRepository {

    private final Map<LottoType, Object> stores = new HashMap<>();

    public void saveUserLottos(final Lottos lottos) {
        stores.put(LottoType.USER_LOTTO, lottos);
    }

    public Optional<Lottos> findUserLottos() {
        return Optional.ofNullable((Lottos) stores.get(LottoType.USER_LOTTO));
    }

    public void saveWinningNumber(final Lotto winningNumber) {
        stores.put(LottoType.WINNING_LOTTO, winningNumber);
    }
}
