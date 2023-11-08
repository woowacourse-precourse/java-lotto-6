package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CreateLotto {
    public List<Lotto> create(PurchaseAmount purchaseAmount) {
        int lottoCount = getLottoCount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }
    private int getLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / 1000;
    }
    private Lotto getLotto() {
        List<Integer> randomNum = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(randomNum);
    }
}
