package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int lottoPrice = 1000;

    public List<Lotto> issueLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int purchasedLottoCount = calculatePurchasedLottoCount(purchaseAmount);
        for (double issuedLottoCount = 1; issuedLottoCount <= purchasedLottoCount; issuedLottoCount++) {
            lottos.add(createRandomLotto());
        }
        return lottos;
    }

    private int calculatePurchasedLottoCount(int purchaseAmount) {
        return purchaseAmount / lottoPrice;
    }

    private Lotto createRandomLotto() {
        return new Lotto(createRandomNumbers());
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
