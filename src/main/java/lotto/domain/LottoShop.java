package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final NumberGenerator numberGenerator;

    public LottoShop(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createByBuyerLotto(Amount amount) {
        int lottoCount = amount.getLottoCount();
        List<Lotto> buyerLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            buyerLotto.add(new Lotto(numberGenerator.generate()));
        }
        return buyerLotto;
    }
}
