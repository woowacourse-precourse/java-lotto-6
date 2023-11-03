package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final Integer LOTTO_PRICE = 1000;

    private int purchaseAmount;
    private int lottoPurchaseQuantity;

    private LottoStore(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoStore of(int purchaseAmount) {
        return new LottoStore(purchaseAmount);
    }

    public Lottos buyLotto() {
        calculatePurchaseQuantity(purchaseAmount);
        return createLottos();
    }

    private void calculatePurchaseQuantity(int purchaseAmount) {
        this.lottoPurchaseQuantity = purchaseAmount / LOTTO_PRICE;
    }

    private Lottos createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseQuantity; i++) {
            lottos.add(createLotto());
        }
        return Lottos.of(lottos);
    }

    private Lotto createLotto() {
        return Lotto.of(createLottoNumber());
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
