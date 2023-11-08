package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShop {
    public static final int LOTTO_PRICE = 1000;

    public int buyLotto(int money) {
        return money / LOTTO_PRICE;
    }

    public Lotto generateLottoTicket() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);
        return new Lotto(lotto);
    }
}

