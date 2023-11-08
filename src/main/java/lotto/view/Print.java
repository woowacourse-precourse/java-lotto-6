package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.global.Prize;

public class Print {
    public static void getAmount() {
        System.out.println(Announce.GET_AMOUNT);
    }

    public static void purchase(Integer amount, List<Lotto> lottos) {
        System.out.println(Announce.NEW_LINE + Announce.purchaseCount(amount));
        purchasedLottoNumber(lottos);
    }

    private static void purchasedLottoNumber(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void getWinNumbers() {
        System.out.println(Announce.NEW_LINE + Announce.GET_WIN_NUMBER);
    }

    public static void getBonusNumber() {
        System.out.println(Announce.NEW_LINE + Announce.Get_BONUS_NUMBER);
    }

    public static void statistic(Result result, Double yieldRate) {
        System.out.println(Announce.NEW_LINE + Announce.WIN_STATISTIC);

        for (Prize prize: Arrays.asList(Prize.values())) {
            if (prize == Prize.NONE) { 
                continue;
            }
            System.out.println(Announce.result(prize, result.getWinCount(prize)));
        }
        System.out.println(Announce.yieldRate(yieldRate));
    }
}
