package lotto.model;

import static lotto.constants.LottoRule.LOTTO_COST;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static final int DIVIDE_REMAIN_VALUE = 0;

    private final int money;

    private Shop(final int money) {
        this.money = money;
    }

    public static Shop withOrderedMoney(final int money) {
        return new Shop(money);
    }

    public List<Lotto> createLottos() {
        int lottoSize = calculateBuyLottoSize(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoSize; i++) {
            List<Integer> numbers = LottoMachine.pickNumbers();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private int calculateBuyLottoSize(final int money) {
        return money / LOTTO_COST.getValue();
    }
}
