package lotto.model;

import lotto.constant.Constants;
import lotto.util.LottoMachine;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {
    private final LottoMachine lottoMachine;
    private final int count;
    private final List<Lotto> purchaseLottos = new ArrayList<>();

    PurchaseLottos(LottoMachine lottoMachine, int purchaseAmount) {
        this.lottoMachine = lottoMachine;
        this.count = purchaseAmount / Constants.PURCHASE_AMOUNT_UNIT.getValue();
        setPurchaseLottos();
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }

    private void setPurchaseLottos() {
        for (int i = 0; i < count; ++i) {
            purchaseLottos.add(new Lotto(lottoMachine.generate()));
        }
    }
}
