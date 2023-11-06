package lotto.domain.lottoseller;

import static lotto.domain.constant.LottoConstant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.money.Money;

public class LottoSeller {

    private final LottoGenerator lottoGenerator;

    public LottoSeller(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> sell(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        while (money.isRemain()) {
            money.pay(LOTTO_PRICE);
            lottos.add(lottoGenerator.generate());
        }

        return Collections.unmodifiableList(lottos);
    }
}
