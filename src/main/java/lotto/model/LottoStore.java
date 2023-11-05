package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constance.GameConst;
import lotto.model.domain.Lottos;
import lotto.model.domain.Money;
import lotto.model.domain.lotto.Lotto;
import lotto.model.lottogenerator.LottoGenerator;
import lotto.exception.LottoGameException;

public class LottoStore {
    private static final int LOTTO_PRICE = GameConst.LOTTO_PRICE;
    private static final int PURCHASE_MAX = GameConst.LOTTO_PURCHASE_LIMIT;

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
