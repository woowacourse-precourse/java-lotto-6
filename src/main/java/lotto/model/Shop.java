package lotto.model;

import static lotto.view.exception.InputException.MONEY_REMAIN_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static final int LOTTO_COST = 1000;
    private static final int DIVIDE_REMAIN_VALUE = 0;

    private final int money;

    private Shop(final int money) {
        this.money = money;
    }

    public static Shop withOrderedMoney(final int money) {
        validateIsRemainValueCorrect(money);
        return new Shop(money);
    }

    public List<Lotto> createLottos() {
        int lottoSize = calculateBuyLottoSize(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoSize; i++) {
            List<Integer> numbers = NumberPicker.createNumbers();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private static void validateIsRemainValueCorrect(final int money) {
        if (money % LOTTO_COST != DIVIDE_REMAIN_VALUE) {
            throw new IllegalArgumentException(MONEY_REMAIN_EXCEPTION.getMessage());
        }
    }

    private int calculateBuyLottoSize(final int money) {
        return money / LOTTO_COST;
    }
}
