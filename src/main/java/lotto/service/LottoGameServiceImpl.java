package lotto.service;

import lotto.domain.LottoCount;
import lotto.utility.TypeConverter;

public class LottoGameServiceImpl implements LottoGameService {
    public LottoCount computeLottoCount(String purchaseAmount) {
        int money = TypeConverter.convertStringToInt(purchaseAmount);
        return LottoCount.from(money);
    }
}
