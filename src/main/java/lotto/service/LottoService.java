package lotto.service;

import lotto.Properties;
import lotto.model.LottoShop;
import lotto.model.LottoTicket;

public class LottoService {

    public LottoTicket buyLotto(long money) {
        LottoShop lottoShop = LottoShop.ofPrice(Properties.LOTTO_PRICE);
        return lottoShop.issueLottoTicket(money);
    }
}
