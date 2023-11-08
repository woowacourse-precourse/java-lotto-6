package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoStatus;

public class LottoGenerator {
    public List<Lotto> generateLotto(long howManyLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < howManyLotto; i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoStatus.MIN_VALUE, LottoStatus.MAX_VALUE, LottoStatus.SIZE);
    }
}
