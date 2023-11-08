package lotto;

import lotto.domain.Lotto;
import lotto.service.LotteryHost;
import lotto.service.LotterySeller;
import lotto.view.Ask;
import lotto.view.Guest;
import lotto.view.Result;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> randomNumbers = new ArrayList<>();

        int count;
        int bonus;

        Guest guest = new Guest();
        LotterySeller lotterySeller = new LotterySeller();
        Ask ask = new Ask();
        Result result = new Result();
        LotteryHost lotteryHost = new LotteryHost();

        count = guest.lottoCount();
        System.out.println(count + "개를 구매했습니다.");

        randomNumbers = lotterySeller.createLottoCount(count);
        for (List<Integer> random : randomNumbers) {
            System.out.println(random);
        }
        System.out.println(" ");

        ask.winningException();

        System.out.println(" ");
        bonus = ask.bonusNumber();

        lotteryHost.compare(ask.winningNumbers, randomNumbers);
        //System.out.println(lotteryHost.compare(ask.winningNumbers, randomNumbers));
        result.winningStatistic();
    }

}
