package lotto.Model.Service;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.Domain.Lotto;
import lotto.Model.Util.LottoUtil;
import System.Exception;

public class LottoService {

    private final List<Lotto> lottos;
    private final LottoUtil lottoUtil;
    private int purchaseMoney;

    public LottoService(LottoUtil lottoUtil) {
        lottos = new ArrayList<>();
        this.lottoUtil = lottoUtil;
    }

    public void createLotto(String purchaseAmount) {
        lottoUtil.validatePurchaseAmount(purchaseAmount);

        purchaseMoney = Integer.parseInt(purchaseAmount);
        lottoUtil.checkPurchaseAmount(purchaseMoney);

        for (int index = 0; index < lottoUtil.calculateCount(purchaseMoney); index++) {
            lottos.add(lottoUtil.pickLottoNumber());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
