package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoStore {

    private static final Integer LOTTO_PRICE = 1000;
    private static final int ZERO_COUNT_VALUE = 0;
    private NumberGenerator numberGenerator;

    private LottoStore(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static LottoStore of(NumberGenerator numberGenerator) {
        return new LottoStore(numberGenerator);
    }

    public List<Lotto> sellLotto(Money money) {
        money.validateDivideBy1000();
        int quantity = calculatePurchaseQuantity(money.getMoney());
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
        List<Integer> lottoNumber = createLottoNumber();
        lottoNumber.sort(Comparator.naturalOrder());
        return Lotto.of(lottoNumber);
    }

    private List<Integer> createLottoNumber() {
        return numberGenerator.generate();
    }
}
