package lotto.domain.lotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class LottosRepository {

    private final Map<LottoType, Object> stores = new EnumMap<>(LottoType.class);

    public void saveUserLottos(final Lottos lottos) {
        stores.put(LottoType.USER_LOTTO, lottos);
    }

    public void saveWinningLotto(final WinningLotto winningLotto) {
        stores.put(LottoType.WINNING_LOTTO, winningLotto);
    }

    public Optional<Lottos> findUserLottos() {
        return Optional.ofNullable((Lottos) stores.get(LottoType.USER_LOTTO));
    }

    public Optional<WinningLotto> findWinningLotto() {
        return Optional.ofNullable((WinningLotto) stores.get(LottoType.WINNING_LOTTO));
    }
}
