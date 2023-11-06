package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<WinningLotto> getWinningLottos(User user) {
        List<WinningLotto> winningLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinningLotto winningLotto = lotto.getWinningLotto(user.getLotto(), user.getBonusNumber());
            winningLottos.add(winningLotto);
        }
        return winningLottos;
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
