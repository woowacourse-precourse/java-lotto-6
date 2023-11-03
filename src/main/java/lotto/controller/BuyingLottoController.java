package lotto.controller;

import lotto.domain.Recipient;
import lotto.service.LottoService;

public class BuyingLottoController {

    private LottoService lottoService = new LottoService();
    public void buyLotto(){
        Recipient recipient = new Recipient();

        String money = recipient.tellMoney();
        lottoService.convertStringtoInt(money);
    }
}
