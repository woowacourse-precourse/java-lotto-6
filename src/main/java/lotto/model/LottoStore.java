package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.PURCHASE_PRICE;
import static lotto.constant.LottoConfig.TOTAL_CHOICE_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static Lottos publishLotto(int money) {
        int ticketNumber = money / PURCHASE_PRICE.getValue();

        return pickLottosNumbers(ticketNumber);
    }

    private static Lottos pickLottosNumbers(int ticketNumber) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < ticketNumber; i++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), TOTAL_CHOICE_NUMBER.getValue()));
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }
}
