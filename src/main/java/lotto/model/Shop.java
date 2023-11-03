package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static final int DEFAULT_COST = 1000;
    private static final int DIVIDE_REMAIN_VALUE = 0;

    private final int lottoCost;

    private Shop(final int lottoCost) {
        this.lottoCost = lottoCost;
    }

    public static Shop createDefault() {
        return new Shop(DEFAULT_COST);
    }

    public List<Lotto> createLottosAsPaid(final int money) {
        validateIsRemainValueCorrect(money);
        int lottoSize = calculateBuyLottoSize(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoSize; i++) {
            List<Integer> numbers = NumberPicker.createNumbers();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private void validateIsRemainValueCorrect(final int money) {
        if (money % lottoCost != DIVIDE_REMAIN_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateBuyLottoSize(final int money) {
        return money / lottoCost;
    }
}
