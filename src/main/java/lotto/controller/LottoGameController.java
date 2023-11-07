package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.PurchaseMoney;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoGameController(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void startGame() {
        PurchaseMoney purchaseMoney = getPurchaseMoney();
        LottoGenerator lottoGenerator =  LottoGenerator.of(lottoNumberGenerator, purchaseMoney);
        Lottos lottos = createLottos(purchaseMoney, lottoGenerator);

    }

    private static PurchaseMoney getPurchaseMoney() {
        try {
            return PurchaseMoney.of(InputView.getPurchaseMoney());
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());

            return getPurchaseMoney();
        }
    }

    private Lottos createLottos(PurchaseMoney purchaseMoney, LottoGenerator lottoGenerator) {
        Lottos lottos = lottoGenerator.createLottos();

        OutputView.printPurchaseCount(purchaseMoney.buyCount());
        OutputView.printLottos(lottos);
        return lottos;
    }



}
