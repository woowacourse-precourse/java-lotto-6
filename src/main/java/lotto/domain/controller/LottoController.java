package lotto.domain.controller;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoSaleSystem;
import lotto.domain.model.LottoWinnerSystem;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private List<Lotto> purchasedLotto;
    private LottoSaleSystem lottoSaleSystem;
    private LottoWinnerSystem lottoWinnerSystem;

    public LottoController() {
        purchasedLotto = new ArrayList<>();
        lottoSaleSystem = new LottoSaleSystem();
        lottoWinnerSystem = new LottoWinnerSystem();
    }


    private void generateLotto(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            Lotto newLotto = new Lotto(Lotto.generateLottoNumber());
            purchasedLotto.add(newLotto);
        }
    }
}
