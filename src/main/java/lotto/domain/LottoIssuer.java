package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public List<Lotto> issue(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        do {
            lottos.add(getLotto());
        } while (purchaseAmount.decrease(LOTTO_PRICE) > 0);
        return List.copyOf(lottos);
    }

    private Lotto getLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_NUMBERS_COUNT).stream().sorted().toList();
        return new Lotto(randomNumbers);
    }
}