package lotto.Model.Service;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.Domain.Lotto;
import lotto.Model.Util.LottoUtil;
import System.Exception;

public class LottoService {

    private final List<Lotto> lottos;
    private final LottoUtil lottoUtil;

    public LottoService(LottoUtil lottoUtil) {
        lottos = new ArrayList<>();
        this.lottoUtil = lottoUtil;
    }

    public void createLotto(String purchaseAmount) {
        int money = Integer.parseInt(purchaseAmount);

        if (!lottoUtil.checkPurchaseAmount(money)) {
            throw new IllegalArgumentException(Exception.LOTTO_PURCHASE_EXCEPTION.getMessage());
        }

        for (int index = 0; index < lottoUtil.calculateCount(money); index++) {
            lottos.add(lottoUtil.pickLottoNumber());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
