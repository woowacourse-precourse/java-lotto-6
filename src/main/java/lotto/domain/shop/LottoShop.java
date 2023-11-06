package lotto.domain.shop;

import java.util.List;
import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;

public class LottoShop {

    private final PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
    private final LottoGenerator lottoGenerator = new LottoGenerator(pickNumbersStrategy);

    private final int LOTTO_PRICE = ShopConfig.LOTTO_PRICE.getValue();

    public int countPurchasableAmount(int cash) {
        validateMaxPurchaseLimit(cash);
        return cash / LOTTO_PRICE;
    }

    public Lotteries purchaseMany(int count) {
        List<Lotto> lotteries = lottoGenerator.generateByCount(count);
        return new Lotteries(lotteries);
    }

    private void validateMaxPurchaseLimit(int cash) {
        if (cash > ShopConfig.LOTTO_PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException(ShopExceptionMessages.LOTTO_PURCHASE_OVER_LIMIT.getMessage());
        }
    }

}
