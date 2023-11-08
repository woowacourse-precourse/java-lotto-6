package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public List<Lotto> buyLottos(int money) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
