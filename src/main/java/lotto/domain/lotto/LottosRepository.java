package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottosRepository {

    private final Map<LottoType, Object> stores = new HashMap<>();

    public void saveUserLottos(final Lottos lottos) {
        stores.put(LottoType.USER_LOTTO, lottos);
    }

    public void saveWinningNumber(final Lotto winningNumber) {
        stores.put(LottoType.WINNING_LOTTO, winningNumber);
    }

    public void saveBonusNumber(final int bonusNumber) {
        stores.put(LottoType.BONUS_NUMBER, bonusNumber);
    }

    public Optional<Lottos> findUserLottos() {
        return Optional.ofNullable((Lottos) stores.get(LottoType.USER_LOTTO));
    }

    public Optional<Lotto> findWinningLotto() {
        return Optional.ofNullable((Lotto) stores.get(LottoType.WINNING_LOTTO));
    }

    public Optional<Integer> findBonusNumber() {
        return Optional.ofNullable((Integer) stores.get(LottoType.BONUS_NUMBER));
    }
}
