package lotto.repository;

import java.util.List;
import lotto.controller.Lotto;

public class UserLottoRepository {

    private final List<Lotto> lottos;

    public UserLottoRepository(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
