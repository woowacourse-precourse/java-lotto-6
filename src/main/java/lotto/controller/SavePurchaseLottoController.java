package lotto.controller;

import lotto.domain.MakeLottoCollection;
import lotto.domain.db.PurchaseLottoCollection;

public class SavePurchaseLottoController {
    public static PurchaseLottoCollection lottoControl(int purchaseLottoCount) {
        return MakeLottoCollection.getCollection(purchaseLottoCount);
    }
}
