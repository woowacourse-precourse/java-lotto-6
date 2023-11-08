package lotto.controller;

import lotto.Lotto;
import lotto.service.Statistics;
import lotto.view.*;
import lotto.service.NumberMatch;
import lotto.service.RandomLottoNumber;

import java.util.List;
import java.util.Set;

public class LottoController {

    private static final String COUNT_MESSAGE = "개를 구매했습니다.";

    private InputBuyLotto inputBuyLotto = new InputBuyLotto();
    private RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
    private InputLottoNumber inputLottoNumber = new InputLottoNumber();
    private InputBonus inputBonus = new InputBonus();
    private NumberMatch numberMatch = new NumberMatch();
    private RankResult rankResult = new RankResult();
    private Statistics statistics;
    private Result result = new Result();



    public void lotto() {
        int money = getMoney();
        int ticket = getTicket(money);
        List<Lotto> lottoNumbers = getLottoNumbers(randomLottoNumber, ticket);
        List<Integer> inputlottoNumbers = inputLottoNumber.getLottoNumbers();
        System.out.println();
        int bonus = inputBonus.getBonus();
        List<Integer> matching = numberMatch.matching(lottoNumbers, inputlottoNumbers);
        List<Boolean> containBonus = numberMatch.containBonusAll(lottoNumbers, bonus);
        rankResult.calculateResult(matching, containBonus);
        statistics = new Statistics(money, rankResult);
        result.printResult(rankResult,statistics);

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

    private int getTicket(int money) {
        int ticketCount = inputBuyLotto.getTicket(money);
        System.out.println();
        System.out.println(ticketCount + COUNT_MESSAGE);
        return ticketCount;
    }

    private List<Lotto> getLottoNumbers(RandomLottoNumber randomLottoNumber,int ticket) {
        List<Lotto> lotto = randomLottoNumber.generateTotalLottoNumbers(ticket);
        showLottoNumbers(lotto);
        return lotto;
    }



}
