package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = createLottos(count);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return randomLottos;
    }
}
