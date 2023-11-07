package lotto.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.model.domain.Player;
import lotto.model.domain.vo.Lotto;
import lotto.model.domain.vo.Lottos;
import lotto.model.domain.vo.Money;

public class LottoStore {

    private static final Integer LOTTO_PRICE = 1000;
    private static final int ZERO_COUNT_VALUE = 0;
    private NumberGenerateStrategy numberGenerateStrategy;

    private LottoStore(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public static LottoStore of(NumberGenerateStrategy numberGenerateStrategy) {
        return new LottoStore(numberGenerateStrategy);
    }

    public Player sellLotto(Money money) {
        money.validateDivideBy1000();
        int quantity = calculatePurchaseQuantity(money.getMoney());
        return Player.from(money, createLottos(quantity));
    }

    private int calculatePurchaseQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    private Lottos createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        while (quantity > ZERO_COUNT_VALUE) {
            lottos.add(createLotto());
            quantity--;
        }
        return Lottos.of(lottos);
    }

    private Lotto createLotto() {
        List<Integer> lottoNumber = createLottoNumber();
        lottoNumber.sort(Comparator.naturalOrder());
        return Lotto.of(lottoNumber);
    }

    private List<Integer> createLottoNumber() {
        return numberGenerateStrategy.generate();
    }
}
