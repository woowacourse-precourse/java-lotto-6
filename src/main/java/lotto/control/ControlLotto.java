package lotto.control;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class ControlLotto {
    private final ArrayList<Lotto> lottos = new ArrayList<>();


    public void createLottos(long n) {
        for (int i = 0; i < n; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public ArrayList<Lotto> getlottos() {
        return this.lottos;
    }

}
