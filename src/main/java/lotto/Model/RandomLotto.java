package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomLotto {

    private List<Lotto> lottos;

    public RandomLotto() {
        lottos = new ArrayList<>();
    }

    public Lotto generateRandomLottos() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }
}
