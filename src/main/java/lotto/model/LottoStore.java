package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int lottoPrice = 1000;

    public int calculatePurchasedLottoCount(int purchaseAmount) {
        return purchaseAmount / lottoPrice;
    }

    public Lotto createRandomLotto() {
        return new Lotto(createRandomNumbers());
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
