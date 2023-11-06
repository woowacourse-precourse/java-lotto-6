package lotto.domain.shop;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;

public class LottoShop {

    private final PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
    private final LottoGenerator lottoGenerator = new LottoGenerator(pickNumbersStrategy);

    private final int LOTTO_PRICE = ShopConfig.LOTTO_PRICE.getValue();

    public List<Lotto> purchase(int cash) {
        int count = cash / LOTTO_PRICE;
        return lottoGenerator.generateByCount(count);
    }

}
