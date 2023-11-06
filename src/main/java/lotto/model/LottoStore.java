package lotto.model;

import java.util.ArrayList;
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

    public List<Lotto> sellLotto(int money) {
        validateDivideBy1000(money);
        int quantity = calculatePurchaseQuantity(money);
        return createLottos(quantity);
    }

    private void validateDivideBy1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액이 아닙니다.");
        }
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
        return numberGenerator.generate();
    }
}
