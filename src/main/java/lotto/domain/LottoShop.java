package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoShop {
    public static final int LOTTO_PRICE = 1000;

    public int buyLotto(int money) {
        return money / LOTTO_PRICE;
    }

}