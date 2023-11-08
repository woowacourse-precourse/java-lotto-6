package lotto.domain;

import lotto.domain.numbermaker.NumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final Integer LOTTO_PRICE = 1000;
    private final NumberMaker numberMaker;

    public LottoMachine(NumberMaker numberMaker) {
        this.numberMaker = numberMaker;
    }

    public List<Lotto> buyLotto(Money money) {
        List<Lotto> lottoBundle = new ArrayList<>();

        Integer lottoCount = computeLottoCount(money);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = issueLotto();
            lottoBundle.add(lotto);
        }

        return lottoBundle;
    }

    private Integer computeLottoCount(Money money) {
        return money.getAmount() / LOTTO_PRICE;
    }

    private Lotto issueLotto() {
        List<Integer> numbers = numberMaker.generateNumbers();
        return new Lotto(numbers);
    }

}
