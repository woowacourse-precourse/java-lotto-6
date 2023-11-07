package lotto.controller;

import lotto.Lotto;
import lotto.service.NumberMatch;
import lotto.service.RandomLottoNumber;
import lotto.view.InputBonus;
import lotto.view.InputBuyLotto;
import lotto.view.InputLottoNumber;

import java.util.List;

public class LottoController {

    private static final String COUNT_MESSAGE = "개를 구매했습니다.";

    private InputBuyLotto inputBuyLotto = new InputBuyLotto();
    private RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
    private InputLottoNumber inputLottoNumber = new InputLottoNumber();
    private InputBonus inputBonus = new InputBonus();
    NumberMatch numberMatch = new NumberMatch();




    public void lotto() {
        int ticket = inputBuyLotto.getTicket(inputBuyLotto.getMoney());
        List<Lotto> lottoNumbers = getLottoNumbers(randomLottoNumber, ticket);
        List<Integer> inputlottoNumbers = inputLottoNumber.getLottoNumbers();
        int bonus = inputBonus.getBonus();
        List<Integer> mathcing = numberMatch.mathcing(lottoNumbers, inputlottoNumbers);
        List<Boolean> containBonus = numberMatch.containBonusAll(lottoNumbers, bonus);

    }

    private void showLottoNumbers(List<Lotto> lottoNumbers) {

        lottoNumbers.forEach(System.out::println);
        System.out.println();
    }

    private int getMoney() {
        InputBuyLotto inputBuyLotto = new InputBuyLotto();
        int money = inputBuyLotto.getMoney();
        return money;
    }

    private int getTicket(InputBuyLotto inputBuyLotto) {
        int ticketCount = inputBuyLotto.getTicket(getMoney());
        System.out.println(ticketCount + COUNT_MESSAGE);
        return ticketCount;
    }

    private List<Lotto> getLottoNumbers(RandomLottoNumber randomLottoNumber,int ticket) {
        List<Lotto> lotto = randomLottoNumber.generateTotalLottoNumbers(ticket);
        showLottoNumbers(lotto);
        return lotto;
    }



}
