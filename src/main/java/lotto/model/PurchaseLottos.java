package lotto.model;

import lotto.constant.Constants;
import lotto.util.LottoMachine;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {
    private final List<Lotto> purchaseLottos = new ArrayList<>();
    private final LottoMachine lottoMachine;
    private final int count;

    public PurchaseLottos(LottoMachine lottoMachine, int purchaseAmount) {
        this.lottoMachine = lottoMachine;
        this.count = getLottosCount(purchaseAmount);
        setPurchaseLottos();
    }

    public List<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }

    public int getCount() {
        return count;
    }

    private int getLottosCount(int purchaseAmount) {
        return purchaseAmount / Constants.PURCHASE_AMOUNT_UNIT.getValue();
    }

    private void setPurchaseLottos() {
        for (int i = 0; i < count; ++i) {
            purchaseLottos.add(new Lotto(lottoMachine.generate()));
        }
    }
}
