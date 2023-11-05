package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Money;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.Lottos;
import lotto.model.domain.lotto.lottogenerator.LottoGenerator;

public class LottoStore {

    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos purchase(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.possibleToPurchaseLotto()) {
            money.purchaseLotto();
            Lotto generatedLotto = lottoGenerator.generate();
            lottos.add(generatedLotto);
        }
        return new Lottos(lottos);
    }
}
