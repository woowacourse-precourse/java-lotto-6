package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> createLottos(int count) {
        for (int i = 0; i < count; i++) {
            addLotto(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private List<Lotto> addLotto(Lotto lotto) {
        lottos.add(lotto);
        return lottos;
    }
}
