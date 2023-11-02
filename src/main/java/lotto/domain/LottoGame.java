package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoGame {

    private final List<Lotto> lottos;
    private final int buyingAmount;

    private LottoGame(final List<Lotto> lottos, final int buyingAmount) {
        this.lottos = lottos;
        this.buyingAmount = buyingAmount;
    }

    public static LottoGame createLottoGame(final int buyingAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Lotto lotto = Lotto.createLotto();
            lottos.add(lotto);
        }
        return new LottoGame(lottos, buyingAmount);
    }

    public void OrderByAsc() {
        for (Lotto lotto : lottos) {
            lotto.numbersOrderByAsc();
        }
    }
}
