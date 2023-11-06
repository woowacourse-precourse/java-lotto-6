package lotto.domain.shop;

import java.util.List;
import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.dto.LottoNumbersDTO;
import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;

public class LottoShop {

    private final PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
    private final LottoNumbersGenerator lottoGenerator = new LottoNumbersGenerator(pickNumbersStrategy);

    private final int LOTTO_PRICE = ShopConfig.LOTTO_PRICE.getValue();

    public int countPurchasableAmount(int cash) {
        validateMaxPurchaseLimit(cash);
        return cash / LOTTO_PRICE;
    }

    public List<LottoNumbersDTO> publishNumbers(int count) {
        return lottoGenerator.generateByCount(count);
    }

    private void validateMaxPurchaseLimit(int cash) {
        if (cash > ShopConfig.LOTTO_PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException(ShopExceptionMessages.LOTTO_PURCHASE_OVER_LIMIT.getMessage());
        }
    }

}
