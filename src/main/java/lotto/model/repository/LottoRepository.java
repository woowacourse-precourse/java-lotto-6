package lotto.model.repository;

import java.util.List;
import lotto.model.domain.Game;
import lotto.model.domain.Lottos;

public class LottoRepository {
    private final Lottos lottos = new Lottos();
    private Game lottoGame;

    public void save(List<Integer> lottoNumbers) {
        lottos.addLotto(lottoNumbers);
    }

    public Lottos findLottos() {
        return lottos;
    }
}
