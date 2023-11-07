package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<WinningLotto> getWinningLottos(User user) {
        return lottos.stream()
                .map(lotto -> lotto.getWinningLotto(user.getLotto(), user.getBonusNumber()))
                .toList();
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
