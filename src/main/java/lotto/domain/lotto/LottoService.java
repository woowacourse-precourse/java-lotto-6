package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.entity.Lotto;
import lotto.domain.lotto.entity.Lottos;
import lotto.domain.lotto.generator.LottoGenerator;
import lotto.domain.lotto.money.Cash;
import lotto.domain.lotto.money.Money;

public class LottoService {

    public static final int LOTTO_PRICE = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    //todo money 래핑 하기
    public Lottos purchaseLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        Cash cash = money.toCash();
        while (cash.canPurchase(LOTTO_PRICE)) {
            lottos.add(generateLotto());
            cash.spend(LOTTO_PRICE);
        }
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        return lottoGenerator.generate();
    }
}
