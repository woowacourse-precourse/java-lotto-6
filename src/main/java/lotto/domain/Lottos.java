package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lotto;

    public Lottos() {
        this.lotto = new ArrayList<>();
    }

    private List<Integer> pickNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void pickLottos() {
        lotto.add(new Lotto(pickNum()));
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
