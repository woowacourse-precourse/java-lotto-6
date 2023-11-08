package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lotto;
    private final int MIN_LOTTO_NUM = 1;
    private final int MAX_LOTTO_NUM = 45;
    private final int LOTTO_COUNT = 6;

    public Lottos() {
        this.lotto = new ArrayList<>();
    }

    private List<Integer> pickNum() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_COUNT);
    }

    public void pickLottos() {
        lotto.add(new Lotto(pickNum()));
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
