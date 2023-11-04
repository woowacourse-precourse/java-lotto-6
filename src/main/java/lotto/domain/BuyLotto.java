package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Application;
import lotto.Lotto;

public class BuyLotto {
    public List<Lotto> buyLotto(long inputPrice) {
        final int HOW_MANY_BUY_LOTTO = (int)(inputPrice / Application.CURRENCY_UNIT);
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < HOW_MANY_BUY_LOTTO; i++) {
            Lotto makeLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.add(makeLotto);
        }

        return lotto;
    }
}
