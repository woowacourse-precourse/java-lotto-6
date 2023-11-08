package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputBuyLottoView;

public class LottoController {


    private Money getLottoMoney(){
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.insertCoin();
        return new Money(money);
    }

    private Lottos getLottos(Money money){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoList(money.getTicket()));
    }
}
