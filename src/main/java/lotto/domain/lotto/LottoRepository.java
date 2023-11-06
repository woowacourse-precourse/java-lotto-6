package lotto.domain.lotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class LottoRepository {

    private final Map<LottoType, Object> stores = new EnumMap<>(LottoType.class);

    public void saveUserLottos(final Lottos lottos) {
        stores.put(LottoType.BUYING_LOTTOS, lottos);
    }

    public void saveWinningLotto(final WinningLotto winningLotto) {
        stores.put(LottoType.WINNING_LOTTO, winningLotto);
    }

    public Optional<Lottos> findUserLottos() {
        return Optional.ofNullable((Lottos) stores.get(LottoType.BUYING_LOTTOS));
    }

    public Optional<WinningLotto> findWinningLotto() {
        return Optional.ofNullable((WinningLotto) stores.get(LottoType.WINNING_LOTTO));
    }
}
