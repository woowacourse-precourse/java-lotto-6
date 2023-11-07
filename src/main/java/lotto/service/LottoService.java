package lotto.service;

import static lotto.common.util.LottoUtil.THOUSAND;

import lotto.common.Validation;

public class LottoService {

    public Integer buyLottoCount(Integer buyPrice) {
        Validation.lottoPriceCheck(buyPrice);
        return buyPrice / THOUSAND.getNumber();
    }

}
