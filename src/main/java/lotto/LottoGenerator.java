package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLotto(int ticket) {
        List<Lotto> allLotto = new ArrayList<>();

        for (int i = 0; i < ticket; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            allLotto.add(lotto);
        }
        return allLotto;
    }
}
