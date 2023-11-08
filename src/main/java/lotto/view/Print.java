package lotto.view;

import java.util.List;

import lotto.domain.Lotto;

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
}
