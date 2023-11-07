package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.service.RandomNumbers;
import lotto.view.InputView;

public class Lottos {
    private final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public Lottos(RandomNumbers randomNumbers, InputView inputView) {
        int money = inputView.insertMoney();
        validate(money);
        lottos = createLottos(money, randomNumbers);
    }

    private List<Lotto> createLottos(int money, RandomNumbers randomNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        int lotto_count = money / LOTTO_PRICE;
        for (int i=0;i<lotto_count;i++) {
            lottos.add(new Lotto(randomNumbers.generate()));
        }
        return lottos;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException();
        }
    }
}
