package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.PurchasedLotto;

public class LottoService {

    public static List<Lotto> lottoGenerator(int purchaseAmount) {
        int pickCount = purchaseAmount / 1000;
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < pickCount; i++) {
            List<Integer> purchasedOneLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(purchasedOneLotto);
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }
}
