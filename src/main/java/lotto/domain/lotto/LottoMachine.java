package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.amount.PurchaseAmount;

public class LottoMachine {

    private final List<Lotto> lottos;

    private LottoMachine() {
        this.lottos = new ArrayList<>();
    }

    public static LottoMachine initial() {
        return new LottoMachine();
    }

    public Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        while (purchaseAmount.isEnough()) {
            purchaseAmount = buyLotto(purchaseAmount);
        }
        return Lottos.from(Collections.unmodifiableList(lottos));
    }

    private PurchaseAmount buyLotto(PurchaseAmount purchaseAmount) {
        lottos.add(Lotto.from(Randoms.pickUniqueNumbersInRange(1, 45, 6))); // 이거 랜덤하게 로또 사야지
        return purchaseAmount.subtractLottoCost();
    }
}
