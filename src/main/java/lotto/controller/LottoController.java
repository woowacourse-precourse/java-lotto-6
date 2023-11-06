package lotto.controller;

import lotto.Lotto;
import lotto.PublicLotto;
import lotto.service.RandomLottoNumber;
import lotto.view.InputBuyLotto;

public class LottoController {

    public void lotto() {
        InputBuyLotto inputBuyLotto = new InputBuyLotto();
        int money = inputBuyLotto.getMoney();
        int ticketCount = inputBuyLotto.getTicket(money);

        RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
        PublicLotto publicLotto = new PublicLotto(randomLottoNumber.generateTotalLottoNumbers(ticketCount));
        System.out.println(publicLotto.getLotto());
    }
}
