package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.PURCHASE_PRICE;
import static lotto.constant.LottoConfig.TOTAL_CHOICE_NUMBER;
import static lotto.constant.PrintMessages.PURCHASES_NUMBER;

public class LottoStore {
    public static Lottos publishLotto(int money) {
        int ticketNumber = money / PURCHASE_PRICE.getValue();
        System.out.printf(PURCHASES_NUMBER, ticketNumber);
        Lottos lottos = pickLottosNumbers(ticketNumber);

        return lottos;
    }

    private static Lottos pickLottosNumbers(int ticketNumber) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < ticketNumber; i++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), TOTAL_CHOICE_NUMBER.getValue()));
            lottos.add(lotto);
        }
        return lottos;
    }
}
