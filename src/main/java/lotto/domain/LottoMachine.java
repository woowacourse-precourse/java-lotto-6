package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private int howManyLotto(Money money) {
        return money.getMoney() / ValidationConstants.STANDARD_UNIT;
    }

    private Lotto issueLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public Lottos issueLottos(Money money) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for(int i = 0; i < howManyLotto(money); i++) {
            issuedLottos.add(issueLotto());
        }
        return new Lottos(issuedLottos);
    }
}
