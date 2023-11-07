package lotto.domain;

import lotto.domain.db.PurchaseLotto;
import lotto.domain.db.PurchaseLottoCollection;

import java.util.ArrayList;
import java.util.List;

public class MakeLottoCollection {
    public static PurchaseLottoCollection getCollection(int purchaseLottoCount) {
        List<PurchaseLotto> purchaseLottos = new ArrayList<>();

        for (int i = 0; i < purchaseLottoCount; i++) {
            List<Integer> lottoNumber = new PurchaseLottoGetter().getRandomNumbers();
            PurchaseLotto newLotto = new PurchaseLotto(lottoNumber);
            purchaseLottos.add(newLotto);
        }
        PurchaseLottoCollection newLottoCollection = new PurchaseLottoCollection(purchaseLottos);

        return newLottoCollection;
    }
}
