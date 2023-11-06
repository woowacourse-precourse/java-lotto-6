package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.PURCHASE_PRICE;
import static lotto.constant.LottoConfig.TOTAL_CHOICE_NUMBER;

public class LottoStore {
    public static int publishLotto(int money) {
        Lottos lottos = new Lottos();
        int ticketNumber = money / PURCHASE_PRICE.getValue();

        return ticketNumber;
    }
}
