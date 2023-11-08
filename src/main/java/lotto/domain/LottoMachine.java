package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Money lottoPrice;
    private final NumberGenerator numberGenerator;

    LottoMachine(Money lottoPrice, NumberGenerator numberGenerator) {
        this.lottoPrice = lottoPrice;
        this.numberGenerator = numberGenerator;

    }

    public List<Lotto> buyLotto(Money purchaseMoney) {
        final Integer lottoCount = lottoPrice.divide(purchaseMoney);
        final List<Lotto> lottoBundle = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto newLotto = issueLotto();
            lottoBundle.add(newLotto);
        }

        return lottoBundle;
    }

    private Lotto issueLotto() {
        List<Integer> numbers = numberGenerator.generate();
        return new Lotto(numbers);
    }
}
