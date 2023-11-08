package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static Lottos createLottos(int purchaseNumber) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            lottos.add(LottoFactory.createLotto());
        }
        return new Lottos(lottos);
    }
}
