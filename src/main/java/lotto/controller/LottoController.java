package lotto.controller;

import lotto.Lotto;
import lotto.PublicLotto;
import lotto.service.RandomLottoNumber;
import lotto.view.InputBuyLotto;

import java.util.List;

public class LottoController {

    private static final String COUNT_MESSAGE = "개를 구매했습니다.";
    public void lotto() {
        InputBuyLotto inputBuyLotto = new InputBuyLotto();
        int money = inputBuyLotto.getMoney();
        int ticketCount = inputBuyLotto.getTicket(money);
        System.out.println(ticketCount + COUNT_MESSAGE);

        RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
        PublicLotto publicLotto = new PublicLotto(randomLottoNumber.generateTotalLottoNumbers(ticketCount));
        List<Lotto> lotto = publicLotto.getLotto();
        showLottoNumbers(lotto);


    }

    private void showLottoNumbers(List<Lotto> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }
}
