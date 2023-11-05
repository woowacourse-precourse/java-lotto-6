package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final Integer LOTTO_PRICE = 1000;
    private static final int ZERO_COUNT_VALUE = 0;

    private LottoStore() {
    }

    public static LottoStore of() {
        return new LottoStore();
    }

    public List<Lotto> sellLotto(int money) {
        int quantity = calculatePurchaseQuantity(money);
        return createLottos(quantity);
    }

    private int calculatePurchaseQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        while (quantity > ZERO_COUNT_VALUE) {
            lottos.add(createLotto());
            quantity--;
        }
        return lottos;
    }

    private Lotto createLotto() {
        return Lotto.of(createLottoNumber());
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
