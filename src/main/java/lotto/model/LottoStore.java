package lotto.model;

import static lotto.model.constans.LottoConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoStore {
    private static final int lottoPrice = LOTTO_PRICE.value();

    public int calculatePurchasedLottoAmount(int purchaseAmount) {
        return purchaseAmount / lottoPrice;
    }

    public Lotto issueRandomLotto() {
        return new Lotto(createRandomNumbers());
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
