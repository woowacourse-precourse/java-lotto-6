package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.controller.LottoController;

public class BuyLotto {
    public List<Lotto> buyLotto(long inputPrice) {
        final int HOW_MANY_BUY_LOTTO = (int)(inputPrice / LottoController.CURRENCY_UNIT);
        List<Lotto> lotto = new ArrayList<>();
        Numbers numbers = new Numbers();

        for (int i = 0; i < HOW_MANY_BUY_LOTTO; i++) {
            Lotto makeLotto = new Lotto(numbers.createRandomNumbers());
            lotto.add(makeLotto);
        }

        return lotto;
    }
}
